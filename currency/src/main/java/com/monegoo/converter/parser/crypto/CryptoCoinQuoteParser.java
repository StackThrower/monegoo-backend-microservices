package com.monegoo.converter.parser.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCoinQuoteParser {

    public CryptoCoinQuoteUSDParser USD;
}
