package com.monegoo.notification.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.monegoo.notification.db.DeviceRepository;
import com.monegoo.notification.db.WatcherRepository;
import com.monegoo.notification.db.entity.Device;
import com.monegoo.notification.db.entity.Watcher;
import com.monegoo.notification.entity.NetworkHeader;
import com.monegoo.notification.model.internal.CryptoCurrenciesApiModel;
import com.monegoo.notification.model.internal.CryptoCurrencyApiModel;
import com.monegoo.notification.model.internal.CurrenciesApiModel;
import com.monegoo.notification.model.internal.CurrencyApiModel;
import com.monegoo.notification.model.push.PushMessageModel;
import com.monegoo.notification.model.push.PushNotificationModel;
import com.monegoo.notification.service.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.*;

@Component
@EnableScheduling
public class NotificationService {

    @Value("${monegoo.service.currency}")
    private String currencyService;

    @Value("${monegoo.push-notification.key}")
    private String pushNotificationToken;

    @Autowired
    private WatcherRepository watcherRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private Network network;

    final String PUSH_API_URL = "https://fcm.googleapis.com/fcm/send";

    private CurrencyApiModel getCurrencyRates() {

        final Traverson traverson = new Traverson(URI
                .create(String.format("http://%s/v1/currencies", currencyService)),
                MediaTypes.HAL_JSON);

        final CurrencyApiModel response = traverson
                .follow()
                .toObject(CurrencyApiModel.class);

        return response;
    }

    private CryptoCurrencyApiModel getCryptoRates() {

        final Traverson traverson = new Traverson(URI
                .create(String.format("http://%s/v1/crypto", currencyService)),
                MediaTypes.HAL_JSON);

        final CryptoCurrencyApiModel response = traverson
                .follow()
                .toObject(CryptoCurrencyApiModel.class);

        return response;
    }


    private Map<String, BigDecimal> convertCurrencyApiModelToMap(CurrenciesApiModel model) {
        Map<String, BigDecimal> result = new HashMap<>();
        Field[] allFields = CurrenciesApiModel.class.getDeclaredFields();
        for (Field field : allFields) {

            try {
                BigDecimal value = (BigDecimal) field.get(model);
                result.put(field.getName(), value);
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    private Map<String, BigDecimal> convertCryptoApiModelToMap(CryptoCurrenciesApiModel model) {
        Map<String, BigDecimal> result = new HashMap<>();
        Field[] allFields = CryptoCurrenciesApiModel.class.getDeclaredFields();
        for (Field field : allFields) {

            try {
                BigDecimal value = (BigDecimal) field.get(model);
                result.put(field.getName(), value);
            } catch (Exception ignored) {
            }
        }

        return result;
    }


    private void sentPush(String msg, String title, String userToken) {
        String payload;
        PushMessageModel pushMessageModel = new PushMessageModel(
                userToken,
                new PushNotificationModel(msg, "high", title)
        );

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            payload = ow.writeValueAsString(pushMessageModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String response = network.post(PUSH_API_URL,
                Optional.of(
                        List.of(
                                new NetworkHeader("Content-Type", "application/json; charset=UTF-8"),
                                new NetworkHeader("Authorization", String.format("key=%s", pushNotificationToken))
                        )
                ),
                Optional.of(payload)
        );


        System.out.println(response);
    }


    @Scheduled(initialDelay = 1_000, fixedDelay = 5_000)
    void verifyWatchers() {

        CurrencyApiModel currencyApiModel = getCurrencyRates();
        Map<String, BigDecimal> currencyRates = convertCurrencyApiModelToMap(currencyApiModel.getData());

        CryptoCurrencyApiModel cryptoApiModel = getCryptoRates();
        Map<String, BigDecimal> cryptoRates = convertCryptoApiModelToMap(cryptoApiModel.getData());

        List<Watcher> watcherList = watcherRepository.getUnprocessed();

        watcherList.forEach(watcher -> {

            for (Map.Entry<String, BigDecimal> rate : currencyRates.entrySet()) {
                processRate(rate, watcher, false);
            }
            for (Map.Entry<String, BigDecimal> rate : cryptoRates.entrySet()) {
                processRate(rate, watcher, true);
            }

        });
    }


    private void processRate(Map.Entry<String, BigDecimal> rate, Watcher watcher, boolean isCrypto) {
        if (rate.getKey().equalsIgnoreCase(watcher.getCode())) {
            BigDecimal oneNumber = new BigDecimal("1.0");
            BigDecimal rateValue = isCrypto ? oneNumber.divide(rate.getValue(), 8, RoundingMode.HALF_UP) : rate.getValue();

            if (watcher.getEnabled()) {
                double currentRate = rateValue.doubleValue();
                currentRate = Math.round(currentRate * 100.0) / 100.0;

                if (currentRate < Math.round(watcher.getMinRate().doubleValue() * 100.0) / 100.0) {
                    String msg = String.format("Currency %s is %.2f less than min expected value %.2f",
                            watcher.getCode().toUpperCase(),
                            currentRate,
                            watcher.getMinRate());
                    System.out.println(msg);

                    Optional<Device> deviceOpt = deviceRepository.findById(watcher.getUser());
                    deviceOpt.ifPresent(device -> sentPush(msg, "Rate update", device.getPushToken()));

                    watcher.setEnabled(false);
                }

                if (currentRate > Math.round(watcher.getMaxRate().doubleValue() * 100.0) / 100.0) {
                    String msg = String.format("Currency %s is %.2f more than max expected value %.2f",
                            watcher.getCode().toUpperCase(),
                            currentRate,
                            watcher.getMaxRate());

                    System.out.println(msg);

                    Optional<Device> deviceOpt = deviceRepository.findById(watcher.getUser());
                    deviceOpt.ifPresent(device -> sentPush(msg, "Rate update", device.getPushToken()));

                    watcher.setEnabled(false);
                }

                watcher.setLastVerified(new Date());
                watcherRepository.save(watcher);
            }
        }
    }
}
