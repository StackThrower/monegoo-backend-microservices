package com.monegoo.converter.parser.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCoinQuoteUSDParser {
    public BigDecimal price;
}
