package com.monegoo.converter.controller;

import com.monegoo.converter.response.HomeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping(value = "/")
    ResponseEntity<HomeResponse> getCurrencies() {

        HomeResponse homeResponse = HomeResponse.builder().version("1.0.9").build();

        return new ResponseEntity<>(homeResponse,
                HttpStatus.OK);
    }
}
