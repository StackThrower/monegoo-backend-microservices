package com.monegoo.notification.controller;

import com.monegoo.notification.db.DeviceRepository;
import com.monegoo.notification.db.WatcherRepository;
import com.monegoo.notification.db.entity.Device;
import com.monegoo.notification.db.entity.Watcher;
import com.monegoo.notification.model.DeviceModel;
import com.monegoo.notification.model.WatcherCleanModel;
import com.monegoo.notification.model.WatcherModel;
import com.monegoo.notification.response.DeviceApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class NotificationController {

    @Value("${monegoo.access.key}")
    private String accessKey;

    private DeviceRepository deviceRepository;

    private WatcherRepository watcherRepository;

    @Autowired
    NotificationController(DeviceRepository deviceRepository, WatcherRepository watcherRepository) {
        this.deviceRepository = deviceRepository;
        this.watcherRepository = watcherRepository;
    }


    private String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("wrong md5");
        }
    }

    @PostMapping(value = "/token")
    ResponseEntity<DeviceModel> addToken(@ModelAttribute DeviceModel request) {

        Device device = new Device();

        if (request.getId() > 0) {
            Optional<Device> deviceOpt = deviceRepository.findById(request.getId());
            if (deviceOpt.isPresent()) {
                device = deviceOpt.get();

                if (device.getAccessToken().equals(request.getAccessToken())) {
                    device.setPushToken(request.getPushToken());
                }
            }

        } else {
            device.setPushToken(request.getPushToken());
            device.setAccessToken(getMd5(String.valueOf(System.currentTimeMillis())));
        }


        deviceRepository.save(device);

        request.setId(device.getId());
        request.setAccessToken(device.getAccessToken());

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

//    @GetMapping(value = "/devices")
//    ResponseEntity<List<DeviceApiResponse>> getDevices(@RequestParam String key) {
//
//        List<DeviceApiResponse> deviceApiResponseList = new ArrayList<>();
//
//        if (accessKey.equalsIgnoreCase(key)) {
//
//            List<com.monegoo.notification.db.entity.Device> devices = deviceRepository.findAll();
//
//            devices.forEach(device -> {
//                        DeviceApiResponse deviceApiResponse = new DeviceApiResponse();
//                        deviceApiResponse.setId(device.getId());
//                        deviceApiResponse.setPushToken(device.getPushToken());
//                        deviceApiResponse.setAccessToken(device.getAccessToken() + "1");
//                        deviceApiResponseList.add(deviceApiResponse);
//                    }
//            );
//        }
//        return new ResponseEntity<>(deviceApiResponseList,
//                HttpStatus.OK);
//
//    }

    @GetMapping(value = "/watchers")
    ResponseEntity<List<WatcherModel>> getWatchers(@RequestParam Integer userId, @RequestParam String accessToken) {
        List<WatcherModel> model = new ArrayList<>();
        if (deviceRepository.isExistByIdAndAccessToken(userId, accessToken)) {
            model = watcherRepository.findByUser(userId).stream().map( watcher ->
                new WatcherModel(watcher.getId(), watcher.getUser(), accessToken,
                        watcher.getCode(), watcher.getMinRate(), watcher.getMaxRate(), watcher.getEnabled())
            ).collect(Collectors.toList());
        }

        return new ResponseEntity<>(model,
                HttpStatus.OK);
    }

    @PostMapping(value = "/watcher")
    ResponseEntity<WatcherModel> addWatcher(@ModelAttribute WatcherModel request) {

        if (deviceRepository.isExistByIdAndAccessToken(request.getUser(), request.getAccessToken())) {
            Watcher watcher = new Watcher();

            watcher.setUser(request.getUser());
            watcher.setCode(request.getCode());
            watcher.setMinRate(request.getMin());
            watcher.setMaxRate(request.getMax());
            watcher.setEnabled(request.getEnabled());
            watcher.setLastVerified(new Date());

            watcherRepository.save(watcher);

            request.setId(watcher.getId());
        }

        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PutMapping(value = "/watcher")
    ResponseEntity<WatcherModel> updateWatcher(@ModelAttribute WatcherModel request) {

        WatcherModel model = new WatcherModel();
        model.setUser(request.getUser());
        model.setAccessToken(request.getAccessToken());

        if (deviceRepository.isExistByIdAndAccessToken(request.getUser(), request.getAccessToken())) {

            Optional<Watcher> watcherOpt = watcherRepository.findByUserAndId(request.getUser(), request.getId());

            if (watcherOpt.isPresent()) {
                Watcher watcher = watcherOpt.get();
                watcher.setEnabled(request.getEnabled());
                watcher.setMinRate(request.getMin());
                watcher.setMaxRate(request.getMax());
                watcherRepository.save(watcher);

                model.setId(watcher.getId());
                model.setCode(watcher.getCode());
                model.setEnabled(watcher.getEnabled());
                model.setMin(watcher.getMinRate());
                model.setMax(watcher.getMaxRate());
                model.setEnabled(watcher.getEnabled());
            }
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @DeleteMapping(value = "/watcher")
    ResponseEntity<WatcherModel> deleteWatcher(@ModelAttribute WatcherModel request) {
        if (deviceRepository.isExistByIdAndAccessToken(request.getUser(), request.getAccessToken())) {
            watcherRepository.deleteById(request.getId());
        }
        return new ResponseEntity<>(request, HttpStatus.OK);
    }


    @DeleteMapping(value = "/watchers")
    ResponseEntity<WatcherCleanModel> cleanWatchers(@ModelAttribute WatcherCleanModel request) {

        if (deviceRepository.isExistByIdAndAccessToken(request.getUser(), request.getAccessToken())) {
            watcherRepository.deleteByUser(request.getUser());
        }

        return new ResponseEntity<>(request, HttpStatus.OK);
    }


}
