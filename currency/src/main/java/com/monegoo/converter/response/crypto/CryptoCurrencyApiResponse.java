package com.monegoo.converter.response.crypto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptoCurrencyApiResponse {

    private CryptoCurrenciesApiResponse data;
    private Long timestamp;
}