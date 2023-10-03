package com.monegoo.converter.parser.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyParser {
    Long timestamp;
    RatesParser rates;
}

