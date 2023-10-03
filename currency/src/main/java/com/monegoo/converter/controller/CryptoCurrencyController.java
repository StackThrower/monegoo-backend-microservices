package com.monegoo.converter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monegoo.converter.db.CryptoCurrencyRepository;
import com.monegoo.converter.db.entity.CryptoCurrency;
import com.monegoo.converter.entity.NetworkHeader;
import com.monegoo.converter.response.crypto.CryptoCurrenciesApiResponse;
import com.monegoo.converter.response.crypto.CryptoCurrenciesApiWithTimestampResponse;
import com.monegoo.converter.response.crypto.CryptoCurrencyApiResponse;
import com.monegoo.converter.service.Network;
import com.monegoo.converter.parser.crypto.CryptoParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CryptoCurrencyController {

    @Value("${monegoo.access.key}")
    private String accessKey;

    @Value("${monegoo.crypto.api-key}")
    private String cryptoApiKey;

    private final String CRYPTO_API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

    private CryptoCurrencyRepository cryptoCurrencyRepository;

    private Network network;

    @Autowired
    CryptoCurrencyController(CryptoCurrencyRepository cryptoCurrencyRepository, Network network) {
        this.cryptoCurrencyRepository = cryptoCurrencyRepository;
        this.network = network;
    }

    @GetMapping(value = "/crypto/history")
    ResponseEntity<List<CryptoCurrenciesApiWithTimestampResponse>> getCurrenciesHistory(@RequestParam Long from, @RequestParam Long to) {

        List<CryptoCurrenciesApiWithTimestampResponse> ret = new ArrayList<>();
        List<CryptoCurrency> cryptoCurrencies = cryptoCurrencyRepository.findCryptoCurrenciesByDates(from, to);

        cryptoCurrencies.forEach(cryptoCurrency -> {

            CryptoCurrenciesApiWithTimestampResponse cryptoCurrenciesResponse = new CryptoCurrenciesApiWithTimestampResponse();
            cryptoCurrenciesResponse.timestamp = cryptoCurrency.getTimestamp();

            cryptoCurrenciesResponse.BTC = cryptoCurrency.getBTC();
            cryptoCurrenciesResponse.ETH = cryptoCurrency.getETH();
            cryptoCurrenciesResponse.USDT = cryptoCurrency.getUSDT();
            cryptoCurrenciesResponse.BNB = cryptoCurrency.getBNB();
            cryptoCurrenciesResponse.USDC = cryptoCurrency.getUSDC();
            cryptoCurrenciesResponse.XRP = cryptoCurrency.getXRP();
            cryptoCurrenciesResponse.ADA = cryptoCurrency.getADA();
            cryptoCurrenciesResponse.DOGE = cryptoCurrency.getDOGE();
            cryptoCurrenciesResponse.SOL = cryptoCurrency.getSOL();
            cryptoCurrenciesResponse.TRX = cryptoCurrency.getTRX();
            cryptoCurrenciesResponse.LTC = cryptoCurrency.getLTC();
            cryptoCurrenciesResponse.MATIC = cryptoCurrency.getMATIC();
            cryptoCurrenciesResponse.DOT = cryptoCurrency.getDOT();
            cryptoCurrenciesResponse.TON = cryptoCurrency.getTON();
            cryptoCurrenciesResponse.WBTC = cryptoCurrency.getWBTC();
            cryptoCurrenciesResponse.DAI = cryptoCurrency.getDAI();
            cryptoCurrenciesResponse.SHIB = cryptoCurrency.getSHIB();
            cryptoCurrenciesResponse.AVAX = cryptoCurrency.getAVAX();
            cryptoCurrenciesResponse.BUSD = cryptoCurrency.getBUSD();
            cryptoCurrenciesResponse.BCH = cryptoCurrency.getBCH();
            cryptoCurrenciesResponse.LEO = cryptoCurrency.getLEO();
            cryptoCurrenciesResponse.LINK = cryptoCurrency.getLINK();
            cryptoCurrenciesResponse.ATOM = cryptoCurrency.getATOM();
            cryptoCurrenciesResponse.TUSD = cryptoCurrency.getTUSD();
            cryptoCurrenciesResponse.UNI = cryptoCurrency.getUNI();
            cryptoCurrenciesResponse.XMR = cryptoCurrency.getXMR();
            cryptoCurrenciesResponse.OKB = cryptoCurrency.getOKB();
            cryptoCurrenciesResponse.ETC = cryptoCurrency.getETC();
            cryptoCurrenciesResponse.XLM = cryptoCurrency.getXLM();
            cryptoCurrenciesResponse.ICP = cryptoCurrency.getICP();
            cryptoCurrenciesResponse.FIL = cryptoCurrency.getFIL();
            cryptoCurrenciesResponse.LDO = cryptoCurrency.getLDO();
            cryptoCurrenciesResponse.HBAR = cryptoCurrency.getHBAR();
            cryptoCurrenciesResponse.APT = cryptoCurrency.getAPT();
            cryptoCurrenciesResponse.CRO = cryptoCurrency.getCRO();
            cryptoCurrenciesResponse.ARB = cryptoCurrency.getARB();
            cryptoCurrenciesResponse.VET = cryptoCurrency.getVET();
            cryptoCurrenciesResponse.NEAR = cryptoCurrency.getNEAR();
            cryptoCurrenciesResponse.QNT = cryptoCurrency.getQNT();
            cryptoCurrenciesResponse.AAVE = cryptoCurrency.getAAVE();
            cryptoCurrenciesResponse.GRT = cryptoCurrency.getGRT();
            cryptoCurrenciesResponse.STX = cryptoCurrency.getSTX();
            cryptoCurrenciesResponse.ALGO = cryptoCurrency.getALGO();
            cryptoCurrenciesResponse.USDP = cryptoCurrency.getUSDP();
            cryptoCurrenciesResponse.FTM = cryptoCurrency.getFTM();
            cryptoCurrenciesResponse.EGLD = cryptoCurrency.getEGLD();
            cryptoCurrenciesResponse.OP = cryptoCurrency.getOP();
            cryptoCurrenciesResponse.APE = cryptoCurrency.getAPE();
            cryptoCurrenciesResponse.SAND = cryptoCurrency.getSAND();
            cryptoCurrenciesResponse.EOS = cryptoCurrency.getEOS();
            cryptoCurrenciesResponse.XTZ = cryptoCurrency.getXTZ();
            cryptoCurrenciesResponse.BIT = cryptoCurrency.getBIT();
            cryptoCurrenciesResponse.THETA = cryptoCurrency.getTHETA();
            cryptoCurrenciesResponse.IMX = cryptoCurrency.getIMX();
            cryptoCurrenciesResponse.RNDR = cryptoCurrency.getRNDR();
            cryptoCurrenciesResponse.MANA = cryptoCurrency.getMANA();
            cryptoCurrenciesResponse.RPL = cryptoCurrency.getRPL();
            cryptoCurrenciesResponse.USDD = cryptoCurrency.getUSDD();
            cryptoCurrenciesResponse.CFX = cryptoCurrency.getCFX();
            cryptoCurrenciesResponse.MKR = cryptoCurrency.getMKR();
            cryptoCurrenciesResponse.AXS = cryptoCurrency.getAXS();
            cryptoCurrenciesResponse.BSV = cryptoCurrency.getBSV();
            cryptoCurrenciesResponse.KCS = cryptoCurrency.getKCS();
            cryptoCurrenciesResponse.NEO = cryptoCurrency.getNEO();
            cryptoCurrenciesResponse.KAVA = cryptoCurrency.getKAVA();
            cryptoCurrenciesResponse.PEPE = cryptoCurrency.getPEPE();
            cryptoCurrenciesResponse.CRV = cryptoCurrency.getCRV();
            cryptoCurrenciesResponse.SNX = cryptoCurrency.getSNX();
            cryptoCurrenciesResponse.GALA = cryptoCurrency.getGALA();
            cryptoCurrenciesResponse.FLOW = cryptoCurrency.getFLOW();
            cryptoCurrenciesResponse.CHZ = cryptoCurrency.getCHZ();
            cryptoCurrenciesResponse.INJ = cryptoCurrency.getINJ();
            cryptoCurrenciesResponse.GUSD = cryptoCurrency.getGUSD();
            cryptoCurrenciesResponse.KLAY = cryptoCurrency.getKLAY();
            cryptoCurrenciesResponse.LUNC = cryptoCurrency.getLUNC();
            cryptoCurrenciesResponse.MIOTA = cryptoCurrency.getMIOTA();
            cryptoCurrenciesResponse.ZEC = cryptoCurrency.getZEC();
            cryptoCurrenciesResponse.PAXG = cryptoCurrency.getPAXG();
            cryptoCurrenciesResponse.GMX = cryptoCurrency.getGMX();
            cryptoCurrenciesResponse.XAUT = cryptoCurrency.getXAUT();
            cryptoCurrenciesResponse.XEC = cryptoCurrency.getXEC();
            cryptoCurrenciesResponse.SUI = cryptoCurrency.getSUI();
            cryptoCurrenciesResponse.MINA = cryptoCurrency.getMINA();
            cryptoCurrenciesResponse.BTT = cryptoCurrency.getBTT();
            cryptoCurrenciesResponse.CSPR = cryptoCurrency.getCSPR();
            cryptoCurrenciesResponse.XDC = cryptoCurrency.getXDC();
            cryptoCurrenciesResponse.HT = cryptoCurrency.getHT();
            cryptoCurrenciesResponse.FXS = cryptoCurrency.getFXS();
            cryptoCurrenciesResponse.GT = cryptoCurrency.getGT();
            cryptoCurrenciesResponse.DASH = cryptoCurrency.getDASH();
            cryptoCurrenciesResponse.TWT = cryptoCurrency.getTWT();
            cryptoCurrenciesResponse.WOO = cryptoCurrency.getWOO();
            cryptoCurrenciesResponse.NEXO = cryptoCurrency.getNEXO();
            cryptoCurrenciesResponse.RUNE = cryptoCurrency.getRUNE();
            cryptoCurrenciesResponse.ZIL = cryptoCurrency.getZIL();
            cryptoCurrenciesResponse.CAKE = cryptoCurrency.getCAKE();
            cryptoCurrenciesResponse.LRC = cryptoCurrency.getLRC();
            cryptoCurrenciesResponse.INCH = cryptoCurrency.getINCH();
            cryptoCurrenciesResponse.ENJ = cryptoCurrency.getENJ();
            cryptoCurrenciesResponse.DYDX = cryptoCurrency.getDYDX();

            ret.add(cryptoCurrenciesResponse);
        });

        return new ResponseEntity<>(ret, HttpStatus.OK);
    }


    @GetMapping(value = "/crypto")
    ResponseEntity<CryptoCurrencyApiResponse> getCurrencies() {
        CryptoCurrency cryptoCurrency = cryptoCurrencyRepository.findTopByOrderByIdDesc();

        CryptoCurrenciesApiResponse cryptoCurrenciesResponse = new CryptoCurrenciesApiResponse();
        cryptoCurrenciesResponse.BTC = cryptoCurrency.getBTC();
        cryptoCurrenciesResponse.ETH = cryptoCurrency.getETH();
        cryptoCurrenciesResponse.USDT = cryptoCurrency.getUSDT();
        cryptoCurrenciesResponse.BNB = cryptoCurrency.getBNB();
        cryptoCurrenciesResponse.USDC = cryptoCurrency.getUSDC();
        cryptoCurrenciesResponse.XRP = cryptoCurrency.getXRP();
        cryptoCurrenciesResponse.ADA = cryptoCurrency.getADA();
        cryptoCurrenciesResponse.DOGE = cryptoCurrency.getDOGE();
        cryptoCurrenciesResponse.SOL = cryptoCurrency.getSOL();
        cryptoCurrenciesResponse.TRX = cryptoCurrency.getTRX();
        cryptoCurrenciesResponse.LTC = cryptoCurrency.getLTC();
        cryptoCurrenciesResponse.MATIC = cryptoCurrency.getMATIC();
        cryptoCurrenciesResponse.DOT = cryptoCurrency.getDOT();
        cryptoCurrenciesResponse.TON = cryptoCurrency.getTON();
        cryptoCurrenciesResponse.WBTC = cryptoCurrency.getWBTC();
        cryptoCurrenciesResponse.DAI = cryptoCurrency.getDAI();
        cryptoCurrenciesResponse.SHIB = cryptoCurrency.getSHIB();
        cryptoCurrenciesResponse.AVAX = cryptoCurrency.getAVAX();
        cryptoCurrenciesResponse.BUSD = cryptoCurrency.getBUSD();
        cryptoCurrenciesResponse.BCH = cryptoCurrency.getBCH();
        cryptoCurrenciesResponse.LEO = cryptoCurrency.getLEO();
        cryptoCurrenciesResponse.LINK = cryptoCurrency.getLINK();
        cryptoCurrenciesResponse.ATOM = cryptoCurrency.getATOM();
        cryptoCurrenciesResponse.TUSD = cryptoCurrency.getTUSD();
        cryptoCurrenciesResponse.UNI = cryptoCurrency.getUNI();
        cryptoCurrenciesResponse.XMR = cryptoCurrency.getXMR();
        cryptoCurrenciesResponse.OKB = cryptoCurrency.getOKB();
        cryptoCurrenciesResponse.ETC = cryptoCurrency.getETC();
        cryptoCurrenciesResponse.XLM = cryptoCurrency.getXLM();
        cryptoCurrenciesResponse.ICP = cryptoCurrency.getICP();
        cryptoCurrenciesResponse.FIL = cryptoCurrency.getFIL();
        cryptoCurrenciesResponse.LDO = cryptoCurrency.getLDO();
        cryptoCurrenciesResponse.HBAR = cryptoCurrency.getHBAR();
        cryptoCurrenciesResponse.APT = cryptoCurrency.getAPT();
        cryptoCurrenciesResponse.CRO = cryptoCurrency.getCRO();
        cryptoCurrenciesResponse.ARB = cryptoCurrency.getARB();
        cryptoCurrenciesResponse.VET = cryptoCurrency.getVET();
        cryptoCurrenciesResponse.NEAR = cryptoCurrency.getNEAR();
        cryptoCurrenciesResponse.QNT = cryptoCurrency.getQNT();
        cryptoCurrenciesResponse.AAVE = cryptoCurrency.getAAVE();
        cryptoCurrenciesResponse.GRT = cryptoCurrency.getGRT();
        cryptoCurrenciesResponse.STX = cryptoCurrency.getSTX();
        cryptoCurrenciesResponse.ALGO = cryptoCurrency.getALGO();
        cryptoCurrenciesResponse.USDP = cryptoCurrency.getUSDP();
        cryptoCurrenciesResponse.FTM = cryptoCurrency.getFTM();
        cryptoCurrenciesResponse.EGLD = cryptoCurrency.getEGLD();
        cryptoCurrenciesResponse.OP = cryptoCurrency.getOP();
        cryptoCurrenciesResponse.APE = cryptoCurrency.getAPE();
        cryptoCurrenciesResponse.SAND = cryptoCurrency.getSAND();
        cryptoCurrenciesResponse.EOS = cryptoCurrency.getEOS();
        cryptoCurrenciesResponse.XTZ = cryptoCurrency.getXTZ();
        cryptoCurrenciesResponse.BIT = cryptoCurrency.getBIT();
        cryptoCurrenciesResponse.THETA = cryptoCurrency.getTHETA();
        cryptoCurrenciesResponse.IMX = cryptoCurrency.getIMX();
        cryptoCurrenciesResponse.RNDR = cryptoCurrency.getRNDR();
        cryptoCurrenciesResponse.MANA = cryptoCurrency.getMANA();
        cryptoCurrenciesResponse.RPL = cryptoCurrency.getRPL();
        cryptoCurrenciesResponse.USDD = cryptoCurrency.getUSDD();
        cryptoCurrenciesResponse.CFX = cryptoCurrency.getCFX();
        cryptoCurrenciesResponse.MKR = cryptoCurrency.getMKR();
        cryptoCurrenciesResponse.AXS = cryptoCurrency.getAXS();
        cryptoCurrenciesResponse.BSV = cryptoCurrency.getBSV();
        cryptoCurrenciesResponse.KCS = cryptoCurrency.getKCS();
        cryptoCurrenciesResponse.NEO = cryptoCurrency.getNEO();
        cryptoCurrenciesResponse.KAVA = cryptoCurrency.getKAVA();
        cryptoCurrenciesResponse.PEPE = cryptoCurrency.getPEPE();
        cryptoCurrenciesResponse.CRV = cryptoCurrency.getCRV();
        cryptoCurrenciesResponse.SNX = cryptoCurrency.getSNX();
        cryptoCurrenciesResponse.GALA = cryptoCurrency.getGALA();
        cryptoCurrenciesResponse.FLOW = cryptoCurrency.getFLOW();
        cryptoCurrenciesResponse.CHZ = cryptoCurrency.getCHZ();
        cryptoCurrenciesResponse.INJ = cryptoCurrency.getINJ();
        cryptoCurrenciesResponse.GUSD = cryptoCurrency.getGUSD();
        cryptoCurrenciesResponse.KLAY = cryptoCurrency.getKLAY();
        cryptoCurrenciesResponse.LUNC = cryptoCurrency.getLUNC();
        cryptoCurrenciesResponse.MIOTA = cryptoCurrency.getMIOTA();
        cryptoCurrenciesResponse.ZEC = cryptoCurrency.getZEC();
        cryptoCurrenciesResponse.PAXG = cryptoCurrency.getPAXG();
        cryptoCurrenciesResponse.GMX = cryptoCurrency.getGMX();
        cryptoCurrenciesResponse.XAUT = cryptoCurrency.getXAUT();
        cryptoCurrenciesResponse.XEC = cryptoCurrency.getXEC();
        cryptoCurrenciesResponse.SUI = cryptoCurrency.getSUI();
        cryptoCurrenciesResponse.MINA = cryptoCurrency.getMINA();
        cryptoCurrenciesResponse.BTT = cryptoCurrency.getBTT();
        cryptoCurrenciesResponse.CSPR = cryptoCurrency.getCSPR();
        cryptoCurrenciesResponse.XDC = cryptoCurrency.getXDC();
        cryptoCurrenciesResponse.HT = cryptoCurrency.getHT();
        cryptoCurrenciesResponse.FXS = cryptoCurrency.getFXS();
        cryptoCurrenciesResponse.GT = cryptoCurrency.getGT();
        cryptoCurrenciesResponse.DASH = cryptoCurrency.getDASH();
        cryptoCurrenciesResponse.TWT = cryptoCurrency.getTWT();
        cryptoCurrenciesResponse.WOO = cryptoCurrency.getWOO();
        cryptoCurrenciesResponse.NEXO = cryptoCurrency.getNEXO();
        cryptoCurrenciesResponse.RUNE = cryptoCurrency.getRUNE();
        cryptoCurrenciesResponse.ZIL = cryptoCurrency.getZIL();
        cryptoCurrenciesResponse.CAKE = cryptoCurrency.getCAKE();
        cryptoCurrenciesResponse.LRC = cryptoCurrency.getLRC();
        cryptoCurrenciesResponse.INCH = cryptoCurrency.getINCH();
        cryptoCurrenciesResponse.ENJ = cryptoCurrency.getENJ();
        cryptoCurrenciesResponse.DYDX = cryptoCurrency.getDYDX();

        CryptoCurrencyApiResponse entity = CryptoCurrencyApiResponse.builder()
                .timestamp(cryptoCurrency.getTimestamp())
                .data(cryptoCurrenciesResponse)
                .build();

        return new ResponseEntity<>(entity,
                HttpStatus.OK);
    }

    @GetMapping(value = "/crypto-add-data")
    String addData(@RequestParam String key) {

        if (accessKey.equalsIgnoreCase(key)) {

            String response = network.get(CRYPTO_API_URL,
                    Optional.of(
                            List.of(
                                    new NetworkHeader("Accepts", "application/json"),
                                    new NetworkHeader("X-CMC_PRO_API_KEY", cryptoApiKey)
                            )
                    ));


            try {
                ObjectMapper mapper = new ObjectMapper();

                CryptoParser currencyParser = mapper.readValue(response, CryptoParser.class);


                CryptoCurrency cryptoCurrency = resetCryptoRecord(new CryptoCurrency());
                currencyParser.getData().forEach(coin -> {

                    switch (coin.symbol.trim()) {
                        case "BTC" -> cryptoCurrency.setBTC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ETH" -> cryptoCurrency.setETH(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "USDT" -> cryptoCurrency.setUSDT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "BNB" -> cryptoCurrency.setBNB(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "USDC" -> cryptoCurrency.setUSDC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "XRP" -> cryptoCurrency.setXRP(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ADA" -> cryptoCurrency.setADA(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "DOGE" -> cryptoCurrency.setDOGE(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "SOL" -> cryptoCurrency.setSOL(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "TRX" -> cryptoCurrency.setTRX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "LTC" -> cryptoCurrency.setLTC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "MATIC" -> cryptoCurrency.setMATIC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "DOT" -> cryptoCurrency.setDOT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "TON" -> cryptoCurrency.setTON(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "WBTC" -> cryptoCurrency.setWBTC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "DAI" -> cryptoCurrency.setDAI(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "AVAX" -> cryptoCurrency.setAVAX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "SHIB" -> cryptoCurrency.setSHIB(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "BUSD" -> cryptoCurrency.setBUSD(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "BCH" -> cryptoCurrency.setBCH(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "LEO" -> cryptoCurrency.setLEO(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "LINK" -> cryptoCurrency.setLINK(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ATOM" -> cryptoCurrency.setATOM(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "TUSD" -> cryptoCurrency.setTUSD(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "UNI" -> cryptoCurrency.setUNI(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "XMR" -> cryptoCurrency.setXMR(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "OKB" -> cryptoCurrency.setOKB(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ETC" -> cryptoCurrency.setETC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "XLM" -> cryptoCurrency.setXLM(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ICP" -> cryptoCurrency.setICP(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "FIL" -> cryptoCurrency.setFIL(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "LDO" -> cryptoCurrency.setLDO(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "HBAR" -> cryptoCurrency.setHBAR(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "APT" -> cryptoCurrency.setAPT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "CRO" -> cryptoCurrency.setCRO(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ARB" -> cryptoCurrency.setARB(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "VET" -> cryptoCurrency.setVET(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "NEAR" -> cryptoCurrency.setNEAR(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "QNT" -> cryptoCurrency.setQNT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "GRT" -> cryptoCurrency.setGRT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "STX" -> cryptoCurrency.setSTX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ALGO" -> cryptoCurrency.setALGO(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "USDP" -> cryptoCurrency.setUSDP(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "AAVE" -> cryptoCurrency.setAAVE(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "EGLD" -> cryptoCurrency.setEGLD(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "FTM" -> cryptoCurrency.setFTM(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "APE" -> cryptoCurrency.setAPE(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "OP" -> cryptoCurrency.setOP(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "SAND" -> cryptoCurrency.setSAND(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "BIT" -> cryptoCurrency.setBIT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "EOS" -> cryptoCurrency.setEOS(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "XTZ" -> cryptoCurrency.setXTZ(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "THETA" -> cryptoCurrency.setTHETA(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "IMX" -> cryptoCurrency.setIMX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "RNDR" -> cryptoCurrency.setRNDR(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "RPL" -> cryptoCurrency.setRPL(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "MANA" -> cryptoCurrency.setMANA(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "USDD" -> cryptoCurrency.setUSDD(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "CFX" -> cryptoCurrency.setCFX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "MKR" -> cryptoCurrency.setMKR(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "AXS" -> cryptoCurrency.setAXS(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "BSV" -> cryptoCurrency.setBSV(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "KCS" -> cryptoCurrency.setKCS(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "KAVA" -> cryptoCurrency.setKAVA(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "NEO" -> cryptoCurrency.setNEO(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "PEPE" -> cryptoCurrency.setPEPE(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "CRV" -> cryptoCurrency.setCRV(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "FLOW" -> cryptoCurrency.setFLOW(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "GALA" -> cryptoCurrency.setGALA(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "SNX" -> cryptoCurrency.setSNX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "GUSD" -> cryptoCurrency.setGUSD(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "CHZ" -> cryptoCurrency.setCHZ(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "INJ" -> cryptoCurrency.setINJ(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "LUNC" -> cryptoCurrency.setLUNC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "KLAY" -> cryptoCurrency.setKLAY(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "MIOTA" -> cryptoCurrency.setMIOTA(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ZEC" -> cryptoCurrency.setZEC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "PAXG" -> cryptoCurrency.setPAXG(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "GMX" -> cryptoCurrency.setGMX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "XAUT" -> cryptoCurrency.setXAUT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "XEC" -> cryptoCurrency.setXEC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "BTT" -> cryptoCurrency.setBTT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "XDC" -> cryptoCurrency.setXDC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "CSPR" -> cryptoCurrency.setCSPR(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "MINA" -> cryptoCurrency.setMINA(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "SUI" -> cryptoCurrency.setSUI(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "HT" -> cryptoCurrency.setHT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "FXS" -> cryptoCurrency.setFXS(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "GT" -> cryptoCurrency.setGT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "DASH" -> cryptoCurrency.setDASH(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "TWT" -> cryptoCurrency.setTWT(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "WOO" -> cryptoCurrency.setWOO(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "NEXO" -> cryptoCurrency.setNEXO(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "CAKE" -> cryptoCurrency.setCAKE(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "RUNE" -> cryptoCurrency.setRUNE(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ZIL" -> cryptoCurrency.setZIL(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "LRC" -> cryptoCurrency.setLRC(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "DYDX" -> cryptoCurrency.setDYDX(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "1INCH" -> cryptoCurrency.setINCH(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                        case "ENJ" -> cryptoCurrency.setENJ(BigDecimal.valueOf(1 / coin.quote.USD.price.floatValue()));
                    }
                });

                cryptoCurrency.setTimestamp(System.currentTimeMillis() / 1000);
                cryptoCurrencyRepository.save(cryptoCurrency);

            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return "ok";
        } else {
            return "error";
        }
    }

    // TODO move to service
    private CryptoCurrency resetCryptoRecord(CryptoCurrency cryptoCurrency) {
        cryptoCurrency.setBTC(BigDecimal.valueOf(0));
        cryptoCurrency.setETH(BigDecimal.valueOf(0));
        cryptoCurrency.setUSDT(BigDecimal.valueOf(0));
        cryptoCurrency.setBNB(BigDecimal.valueOf(0));
        cryptoCurrency.setUSDC(BigDecimal.valueOf(0));
        cryptoCurrency.setXRP(BigDecimal.valueOf(0));
        cryptoCurrency.setADA(BigDecimal.valueOf(0));
        cryptoCurrency.setDOGE(BigDecimal.valueOf(0));
        cryptoCurrency.setSOL(BigDecimal.valueOf(0));
        cryptoCurrency.setTRX(BigDecimal.valueOf(0));
        cryptoCurrency.setLTC(BigDecimal.valueOf(0));
        cryptoCurrency.setMATIC(BigDecimal.valueOf(0));
        cryptoCurrency.setDOT(BigDecimal.valueOf(0));
        cryptoCurrency.setTON(BigDecimal.valueOf(0));
        cryptoCurrency.setWBTC(BigDecimal.valueOf(0));
        cryptoCurrency.setDAI(BigDecimal.valueOf(0));
        cryptoCurrency.setAVAX(BigDecimal.valueOf(0));
        cryptoCurrency.setSHIB(BigDecimal.valueOf(0));
        cryptoCurrency.setBUSD(BigDecimal.valueOf(0));
        cryptoCurrency.setBCH(BigDecimal.valueOf(0));
        cryptoCurrency.setLEO(BigDecimal.valueOf(0));
        cryptoCurrency.setLINK(BigDecimal.valueOf(0));
        cryptoCurrency.setATOM(BigDecimal.valueOf(0));
        cryptoCurrency.setTUSD(BigDecimal.valueOf(0));
        cryptoCurrency.setUNI(BigDecimal.valueOf(0));
        cryptoCurrency.setXMR(BigDecimal.valueOf(0));
        cryptoCurrency.setOKB(BigDecimal.valueOf(0));
        cryptoCurrency.setETC(BigDecimal.valueOf(0));
        cryptoCurrency.setXLM(BigDecimal.valueOf(0));
        cryptoCurrency.setICP(BigDecimal.valueOf(0));
        cryptoCurrency.setFIL(BigDecimal.valueOf(0));
        cryptoCurrency.setLDO(BigDecimal.valueOf(0));
        cryptoCurrency.setHBAR(BigDecimal.valueOf(0));
        cryptoCurrency.setAPT(BigDecimal.valueOf(0));
        cryptoCurrency.setCRO(BigDecimal.valueOf(0));
        cryptoCurrency.setARB(BigDecimal.valueOf(0));
        cryptoCurrency.setVET(BigDecimal.valueOf(0));
        cryptoCurrency.setNEAR(BigDecimal.valueOf(0));
        cryptoCurrency.setQNT(BigDecimal.valueOf(0));
        cryptoCurrency.setGRT(BigDecimal.valueOf(0));
        cryptoCurrency.setSTX(BigDecimal.valueOf(0));
        cryptoCurrency.setALGO(BigDecimal.valueOf(0));
        cryptoCurrency.setUSDP(BigDecimal.valueOf(0));
        cryptoCurrency.setAAVE(BigDecimal.valueOf(0));
        cryptoCurrency.setEGLD(BigDecimal.valueOf(0));
        cryptoCurrency.setFTM(BigDecimal.valueOf(0));
        cryptoCurrency.setAPE(BigDecimal.valueOf(0));
        cryptoCurrency.setOP(BigDecimal.valueOf(0));
        cryptoCurrency.setSAND(BigDecimal.valueOf(0));
        cryptoCurrency.setBIT(BigDecimal.valueOf(0));
        cryptoCurrency.setEOS(BigDecimal.valueOf(0));
        cryptoCurrency.setXTZ(BigDecimal.valueOf(0));
        cryptoCurrency.setTHETA(BigDecimal.valueOf(0));
        cryptoCurrency.setIMX(BigDecimal.valueOf(0));
        cryptoCurrency.setRNDR(BigDecimal.valueOf(0));
        cryptoCurrency.setRPL(BigDecimal.valueOf(0));
        cryptoCurrency.setMANA(BigDecimal.valueOf(0));
        cryptoCurrency.setUSDD(BigDecimal.valueOf(0));
        cryptoCurrency.setCFX(BigDecimal.valueOf(0));
        cryptoCurrency.setMKR(BigDecimal.valueOf(0));
        cryptoCurrency.setAXS(BigDecimal.valueOf(0));
        cryptoCurrency.setBSV(BigDecimal.valueOf(0));
        cryptoCurrency.setKCS(BigDecimal.valueOf(0));
        cryptoCurrency.setKAVA(BigDecimal.valueOf(0));
        cryptoCurrency.setNEO(BigDecimal.valueOf(0));
        cryptoCurrency.setPEPE(BigDecimal.valueOf(0));
        cryptoCurrency.setCRV(BigDecimal.valueOf(0));
        cryptoCurrency.setFLOW(BigDecimal.valueOf(0));
        cryptoCurrency.setGALA(BigDecimal.valueOf(0));
        cryptoCurrency.setSNX(BigDecimal.valueOf(0));
        cryptoCurrency.setGUSD(BigDecimal.valueOf(0));
        cryptoCurrency.setCHZ(BigDecimal.valueOf(0));
        cryptoCurrency.setINJ(BigDecimal.valueOf(0));
        cryptoCurrency.setLUNC(BigDecimal.valueOf(0));
        cryptoCurrency.setKLAY(BigDecimal.valueOf(0));
        cryptoCurrency.setMIOTA(BigDecimal.valueOf(0));
        cryptoCurrency.setZEC(BigDecimal.valueOf(0));
        cryptoCurrency.setPAXG(BigDecimal.valueOf(0));
        cryptoCurrency.setGMX(BigDecimal.valueOf(0));
        cryptoCurrency.setXAUT(BigDecimal.valueOf(0));
        cryptoCurrency.setXEC(BigDecimal.valueOf(0));
        cryptoCurrency.setBTT(BigDecimal.valueOf(0));
        cryptoCurrency.setXDC(BigDecimal.valueOf(0));
        cryptoCurrency.setCSPR(BigDecimal.valueOf(0));
        cryptoCurrency.setMINA(BigDecimal.valueOf(0));
        cryptoCurrency.setSUI(BigDecimal.valueOf(0));
        cryptoCurrency.setHT(BigDecimal.valueOf(0));
        cryptoCurrency.setFXS(BigDecimal.valueOf(0));
        cryptoCurrency.setGT(BigDecimal.valueOf(0));
        cryptoCurrency.setDASH(BigDecimal.valueOf(0));
        cryptoCurrency.setTWT(BigDecimal.valueOf(0));
        cryptoCurrency.setWOO(BigDecimal.valueOf(0));
        cryptoCurrency.setNEXO(BigDecimal.valueOf(0));
        cryptoCurrency.setCAKE(BigDecimal.valueOf(0));
        cryptoCurrency.setRUNE(BigDecimal.valueOf(0));
        cryptoCurrency.setZIL(BigDecimal.valueOf(0));
        cryptoCurrency.setLRC(BigDecimal.valueOf(0));
        cryptoCurrency.setDYDX(BigDecimal.valueOf(0));
        cryptoCurrency.setINCH(BigDecimal.valueOf(0));
        cryptoCurrency.setENJ(BigDecimal.valueOf(0));

        return cryptoCurrency;
    }


    @GetMapping(value = "/crypto-remove-all-data")
    String removeAllData(@RequestParam String key) {

        if (accessKey.equalsIgnoreCase(key)) {
            cryptoCurrencyRepository.deleteAll();
            return "ok";
        } else {
            return "error";
        }
    }


}
