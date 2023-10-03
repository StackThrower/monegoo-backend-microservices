package com.monegoo.converter.parser.crypto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoParser {
    List<CryptoCoinParser> data;
}

