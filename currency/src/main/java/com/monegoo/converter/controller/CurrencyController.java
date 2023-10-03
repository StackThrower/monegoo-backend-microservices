package com.monegoo.converter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monegoo.converter.db.CurrencyRepository;
import com.monegoo.converter.db.entity.Currency;
import com.monegoo.converter.parser.currency.CurrencyParser;
import com.monegoo.converter.parser.currency.RatesParser;
import com.monegoo.converter.response.currency.CurrenciesApiResponse;
import com.monegoo.converter.response.currency.CurrencyApiResponse;
import com.monegoo.converter.service.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CurrencyController {

    @Value("${monegoo.access.key}")
    private String accessKey;

    @Value("${monegoo.currency.api-key}")
    private String currencyApiKey;

    private final String CURRENCY_API_URL = "https://openexchangerates.org/api/latest.json?app_id=%s";

    private CurrencyRepository currencyRepository;
    private Network network;

    @Autowired
    CurrencyController(CurrencyRepository currencyRepository, Network network) {
        this.currencyRepository = currencyRepository;
        this.network = network;
    }


    @GetMapping(value = "/currencies")
    ResponseEntity<CurrencyApiResponse> getCurrencies() {
        Currency currency = currencyRepository.findTopByOrderByIdDesc();

        CurrenciesApiResponse currenciesResponse = new CurrenciesApiResponse();
        currenciesResponse.AED = currency.getAED();
        currenciesResponse.AFN = currency.getAFN();
        currenciesResponse.ALL = currency.getALL();
        currenciesResponse.AMD = currency.getAMD();
        currenciesResponse.ANG = currency.getANG();
        currenciesResponse.AOA = currency.getAOA();
        currenciesResponse.ARS = currency.getARS();
        currenciesResponse.AUD = currency.getAUD();
        currenciesResponse.AWG = currency.getAWG();
        currenciesResponse.AZN = currency.getAZN();
        currenciesResponse.BAM = currency.getBAM();
        currenciesResponse.BBD = currency.getBBD();
        currenciesResponse.BDT = currency.getBDT();
        currenciesResponse.BGN = currency.getBGN();
        currenciesResponse.BHD = currency.getBHD();
        currenciesResponse.BIF = currency.getBIF();
        currenciesResponse.BMD = currency.getBMD();
        currenciesResponse.BND = currency.getBND();
        currenciesResponse.BOB = currency.getBOB();
        currenciesResponse.BRL = currency.getBRL();
        currenciesResponse.BSD = currency.getBSD();
        currenciesResponse.BTC = currency.getBTC();
        currenciesResponse.BTN = currency.getBTN();
        currenciesResponse.BWP = currency.getBWP();
        currenciesResponse.BYN = currency.getBYN();
        currenciesResponse.BZD = currency.getBZD();
        currenciesResponse.CAD = currency.getCAD();
        currenciesResponse.CDF = currency.getCDF();
        currenciesResponse.CHF = currency.getCHF();
        currenciesResponse.CLF = currency.getCLF();
        currenciesResponse.CLP = currency.getCLP();
        currenciesResponse.CNH = currency.getCNH();
        currenciesResponse.CNY = currency.getCNY();
        currenciesResponse.COP = currency.getCOP();
        currenciesResponse.CRC = currency.getCRC();
        currenciesResponse.CUC = currency.getCUC();
        currenciesResponse.CUP = currency.getCUP();
        currenciesResponse.CVE = currency.getCVE();
        currenciesResponse.CZK = currency.getCZK();
        currenciesResponse.DJF = currency.getDJF();
        currenciesResponse.DKK = currency.getDKK();
        currenciesResponse.DOP = currency.getDOP();
        currenciesResponse.DZD = currency.getDZD();
        currenciesResponse.EGP = currency.getEGP();
        currenciesResponse.ERN = currency.getERN();
        currenciesResponse.ETB = currency.getETB();
        currenciesResponse.EUR = currency.getEUR();
        currenciesResponse.FJD = currency.getFJD();
        currenciesResponse.FKP = currency.getFKP();
        currenciesResponse.GBP = currency.getGBP();
        currenciesResponse.GEL = currency.getGEL();
        currenciesResponse.GGP = currency.getGGP();
        currenciesResponse.GHS = currency.getGHS();
        currenciesResponse.GIP = currency.getGIP();
        currenciesResponse.GMD = currency.getGMD();
        currenciesResponse.GNF = currency.getGNF();
        currenciesResponse.GTQ = currency.getGTQ();
        currenciesResponse.GYD = currency.getGYD();
        currenciesResponse.HKD = currency.getHKD();
        currenciesResponse.HNL = currency.getHNL();
        currenciesResponse.HRK = currency.getHRK();
        currenciesResponse.HTG = currency.getHTG();
        currenciesResponse.HUF = currency.getHUF();
        currenciesResponse.IDR = currency.getIDR();
        currenciesResponse.ILS = currency.getILS();
        currenciesResponse.IMP = currency.getIMP();
        currenciesResponse.INR = currency.getINR();
        currenciesResponse.IQD = currency.getIQD();
        currenciesResponse.IRR = currency.getIRR();
        currenciesResponse.ISK = currency.getISK();
        currenciesResponse.JEP = currency.getJEP();
        currenciesResponse.JMD = currency.getJMD();
        currenciesResponse.JOD = currency.getJOD();
        currenciesResponse.JPY = currency.getJPY();
        currenciesResponse.KES = currency.getKES();
        currenciesResponse.KGS = currency.getKGS();
        currenciesResponse.KHR = currency.getKHR();
        currenciesResponse.KMF = currency.getKMF();
        currenciesResponse.KPW = currency.getKPW();
        currenciesResponse.KRW = currency.getKRW();
        currenciesResponse.KWD = currency.getKWD();
        currenciesResponse.KYD = currency.getKYD();
        currenciesResponse.KZT = currency.getKZT();
        currenciesResponse.LAK = currency.getLAK();
        currenciesResponse.LBP = currency.getLBP();
        currenciesResponse.LKR = currency.getLKR();
        currenciesResponse.LRD = currency.getLRD();
        currenciesResponse.LSL = currency.getLSL();
        currenciesResponse.LYD = currency.getLYD();
        currenciesResponse.MAD = currency.getMAD();
        currenciesResponse.MDL = currency.getMDL();
        currenciesResponse.MGA = currency.getMGA();
        currenciesResponse.MKD = currency.getMKD();
        currenciesResponse.MMK = currency.getMMK();
        currenciesResponse.MNT = currency.getMNT();
        currenciesResponse.MOP = currency.getMOP();
        currenciesResponse.MRU = currency.getMRU();
        currenciesResponse.MUR = currency.getMUR();
        currenciesResponse.MVR = currency.getMVR();
        currenciesResponse.MWK = currency.getMWK();
        currenciesResponse.MXN = currency.getMXN();
        currenciesResponse.MYR = currency.getMYR();
        currenciesResponse.MZN = currency.getMZN();
        currenciesResponse.NAD = currency.getNAD();
        currenciesResponse.NGN = currency.getNGN();
        currenciesResponse.NIO = currency.getNIO();
        currenciesResponse.NOK = currency.getNOK();
        currenciesResponse.NPR = currency.getNPR();
        currenciesResponse.NZD = currency.getNZD();
        currenciesResponse.OMR = currency.getOMR();
        currenciesResponse.PAB = currency.getPAB();
        currenciesResponse.PEN = currency.getPEN();
        currenciesResponse.PGK = currency.getPGK();
        currenciesResponse.PHP = currency.getPHP();
        currenciesResponse.PKR = currency.getPKR();
        currenciesResponse.PLN = currency.getPLN();
        currenciesResponse.PYG = currency.getPYG();
        currenciesResponse.QAR = currency.getQAR();
        currenciesResponse.RON = currency.getRON();
        currenciesResponse.RSD = currency.getRSD();
        currenciesResponse.RUB = currency.getRUB();
        currenciesResponse.RWF = currency.getRWF();
        currenciesResponse.SAR = currency.getSAR();
        currenciesResponse.SBD = currency.getSBD();
        currenciesResponse.SCR = currency.getSCR();
        currenciesResponse.SDG = currency.getSDG();
        currenciesResponse.SEK = currency.getSEK();
        currenciesResponse.SGD = currency.getSGD();
        currenciesResponse.SHP = currency.getSHP();
        currenciesResponse.SLL = currency.getSLL();
        currenciesResponse.SOS = currency.getSOS();
        currenciesResponse.SRD = currency.getSRD();
        currenciesResponse.SSP = currency.getSSP();
        currenciesResponse.STD = currency.getSTD();
        currenciesResponse.STN = currency.getSTN();
        currenciesResponse.SVC = currency.getSVC();
        currenciesResponse.SYP = currency.getSYP();
        currenciesResponse.SZL = currency.getSZL();
        currenciesResponse.THB = currency.getTHB();
        currenciesResponse.TJS = currency.getTJS();
        currenciesResponse.TMT = currency.getTMT();
        currenciesResponse.TND = currency.getTND();
        currenciesResponse.TOP = currency.getTOP();
        currenciesResponse.TRY = currency.getTRY();
        currenciesResponse.TTD = currency.getTTD();
        currenciesResponse.TWD = currency.getTWD();
        currenciesResponse.TZS = currency.getTZS();
        currenciesResponse.UAH = currency.getUAH();
        currenciesResponse.UGX = currency.getUGX();
        currenciesResponse.USD = currency.getUSD();
        currenciesResponse.UYU = currency.getUYU();
        currenciesResponse.UZS = currency.getUZS();
        currenciesResponse.VES = currency.getVES();
        currenciesResponse.VND = currency.getVND();
        currenciesResponse.VUV = currency.getVUV();
        currenciesResponse.WST = currency.getWST();
        currenciesResponse.XAF = currency.getXAF();
        currenciesResponse.XAG = currency.getXAG();
        currenciesResponse.XAU = currency.getXAU();
        currenciesResponse.XCD = currency.getXCD();
        currenciesResponse.XDR = currency.getXDR();
        currenciesResponse.XOF = currency.getXOF();
        currenciesResponse.XPD = currency.getXPD();
        currenciesResponse.XPF = currency.getXPF();
        currenciesResponse.XPT = currency.getXPT();
        currenciesResponse.YER = currency.getYER();
        currenciesResponse.ZAR = currency.getZAR();
        currenciesResponse.ZMW = currency.getZMW();
        currenciesResponse.ZWL = currency.getZWL();

        CurrencyApiResponse entity = CurrencyApiResponse.builder()
                .timestamp(currency.getTimestamp())
                .data(currenciesResponse)
                .build();

        return new ResponseEntity<>(entity,
                HttpStatus.OK);
    }


    @GetMapping(value = "/currency-add-data")
    String addData(@RequestParam String key) {

        if (accessKey.equalsIgnoreCase(key)) {

            String response = network.get(String.format(CURRENCY_API_URL, currencyApiKey), Optional.empty());

            try {
                ObjectMapper mapper = new ObjectMapper();
                Currency currency = new Currency();

                CurrencyParser currencyParser = mapper.readValue(response, CurrencyParser.class);
                RatesParser rates = currencyParser.getRates();

                currency.setAED(rates.AED);
                currency.setAFN(rates.AFN);
                currency.setALL(rates.ALL);
                currency.setAMD(rates.AMD);
                currency.setANG(rates.ANG);
                currency.setAOA(rates.AOA);
                currency.setARS(rates.ARS);
                currency.setAUD(rates.AUD);
                currency.setAWG(rates.AWG);
                currency.setAZN(rates.AZN);
                currency.setBAM(rates.BAM);
                currency.setBBD(rates.BBD);
                currency.setBDT(rates.BDT);
                currency.setBGN(rates.BGN);
                currency.setBHD(rates.BHD);
                currency.setBIF(rates.BIF);
                currency.setBMD(rates.BMD);
                currency.setBND(rates.BND);
                currency.setBOB(rates.BOB);
                currency.setBRL(rates.BRL);
                currency.setBSD(rates.BSD);
                currency.setBTC(rates.BTC);
                currency.setBTN(rates.BTN);
                currency.setBWP(rates.BWP);
                currency.setBYN(rates.BYN);
                currency.setBZD(rates.BZD);
                currency.setCAD(rates.CAD);
                currency.setCDF(rates.CDF);
                currency.setCHF(rates.CHF);
                currency.setCLF(rates.CLF);
                currency.setCLP(rates.CLP);
                currency.setCNH(rates.CNH);
                currency.setCNY(rates.CNY);
                currency.setCOP(rates.COP);
                currency.setCRC(rates.CRC);
                currency.setCUC(rates.CUC);
                currency.setCUP(rates.CUP);
                currency.setCVE(rates.CVE);
                currency.setCZK(rates.CZK);
                currency.setDJF(rates.DJF);
                currency.setDKK(rates.DKK);
                currency.setDOP(rates.DOP);
                currency.setDZD(rates.DZD);
                currency.setEGP(rates.EGP);
                currency.setERN(rates.ERN);
                currency.setETB(rates.ETB);
                currency.setEUR(rates.EUR);
                currency.setFJD(rates.FJD);
                currency.setFKP(rates.FKP);
                currency.setGBP(rates.GBP);
                currency.setGEL(rates.GEL);
                currency.setGGP(rates.GGP);
                currency.setGHS(rates.GHS);
                currency.setGIP(rates.GIP);
                currency.setGMD(rates.GMD);
                currency.setGNF(rates.GNF);
                currency.setGTQ(rates.GTQ);
                currency.setGYD(rates.GYD);
                currency.setHKD(rates.HKD);
                currency.setHNL(rates.HNL);
                currency.setHRK(rates.HRK);
                currency.setHTG(rates.HTG);
                currency.setHUF(rates.HUF);
                currency.setIDR(rates.IDR);
                currency.setILS(rates.ILS);
                currency.setIMP(rates.IMP);
                currency.setINR(rates.INR);
                currency.setIQD(rates.IQD);
                currency.setIRR(rates.IRR);
                currency.setISK(rates.ISK);
                currency.setJEP(rates.JEP);
                currency.setJMD(rates.JMD);
                currency.setJOD(rates.JOD);
                currency.setJPY(rates.JPY);
                currency.setKES(rates.KES);
                currency.setKGS(rates.KGS);
                currency.setKHR(rates.KHR);
                currency.setKMF(rates.KMF);
                currency.setKPW(rates.KPW);
                currency.setKRW(rates.KRW);
                currency.setKWD(rates.KWD);
                currency.setKYD(rates.KYD);
                currency.setKZT(rates.KZT);
                currency.setLAK(rates.LAK);
                currency.setLBP(rates.LBP);
                currency.setLKR(rates.LKR);
                currency.setLRD(rates.LRD);
                currency.setLSL(rates.LSL);
                currency.setLYD(rates.LYD);
                currency.setMAD(rates.MAD);
                currency.setMDL(rates.MDL);
                currency.setMGA(rates.MGA);
                currency.setMKD(rates.MKD);
                currency.setMMK(rates.MMK);
                currency.setMNT(rates.MNT);
                currency.setMOP(rates.MOP);
                currency.setMRU(rates.MRU);
                currency.setMUR(rates.MUR);
                currency.setMVR(rates.MVR);
                currency.setMWK(rates.MWK);
                currency.setMXN(rates.MXN);
                currency.setMYR(rates.MYR);
                currency.setMZN(rates.MZN);
                currency.setNAD(rates.NAD);
                currency.setNGN(rates.NGN);
                currency.setNIO(rates.NIO);
                currency.setNOK(rates.NOK);
                currency.setNPR(rates.NPR);
                currency.setNZD(rates.NZD);
                currency.setOMR(rates.OMR);
                currency.setPAB(rates.PAB);
                currency.setPEN(rates.PEN);
                currency.setPGK(rates.PGK);
                currency.setPHP(rates.PHP);
                currency.setPKR(rates.PKR);
                currency.setPLN(rates.PLN);
                currency.setPYG(rates.PYG);
                currency.setQAR(rates.QAR);
                currency.setRON(rates.RON);
                currency.setRSD(rates.RSD);
                currency.setRUB(rates.RUB);
                currency.setRWF(rates.RWF);
                currency.setSAR(rates.SAR);
                currency.setSBD(rates.SBD);
                currency.setSCR(rates.SCR);
                currency.setSDG(rates.SDG);
                currency.setSEK(rates.SEK);
                currency.setSGD(rates.SGD);
                currency.setSHP(rates.SHP);
                currency.setSLL(rates.SLL);
                currency.setSOS(rates.SOS);
                currency.setSRD(rates.SRD);
                currency.setSSP(rates.SSP);
                currency.setSTD(rates.STD);
                currency.setSTN(rates.STN);
                currency.setSVC(rates.SVC);
                currency.setSYP(rates.SYP);
                currency.setSZL(rates.SZL);
                currency.setTHB(rates.THB);
                currency.setTJS(rates.TJS);
                currency.setTMT(rates.TMT);
                currency.setTND(rates.TND);
                currency.setTOP(rates.TOP);
                currency.setTRY(rates.TRY);
                currency.setTTD(rates.TTD);
                currency.setTWD(rates.TWD);
                currency.setTZS(rates.TZS);
                currency.setUAH(rates.UAH);
                currency.setUGX(rates.UGX);
                currency.setUSD(rates.USD);
                currency.setUYU(rates.UYU);
                currency.setUZS(rates.UZS);
                currency.setVES(rates.VES);
                currency.setVND(rates.VND);
                currency.setVUV(rates.VUV);
                currency.setWST(rates.WST);
                currency.setXAF(rates.XAF);
                currency.setXAG(rates.XAG);
                currency.setXAU(rates.XAU);
                currency.setXCD(rates.XCD);
                currency.setXDR(rates.XDR);
                currency.setXOF(rates.XOF);
                currency.setXPD(rates.XPD);
                currency.setXPF(rates.XPF);
                currency.setXPT(rates.XPT);
                currency.setYER(rates.YER);
                currency.setZAR(rates.ZAR);
                currency.setZMW(rates.ZMW);
                currency.setZWL(rates.ZWL);

                currency.setTimestamp(currencyParser.getTimestamp());

                currencyRepository.save(currency);


            } catch (JsonProcessingException e) {
                System.out.println(e.getMessage());
            }



            return "ok";
        } else {
            return "error";
        }
    }


    @GetMapping(value = "/currency-remove-all-data")
    String removeAllData(@RequestParam String key) {

        if (accessKey.equalsIgnoreCase(key)) {
            currencyRepository.deleteAll();
            return "ok";
        } else {
            return "error";
        }
    }


}
