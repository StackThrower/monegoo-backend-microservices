package com.monegoo.converter.response.currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyApiResponse {

    private CurrenciesApiResponse data;
    private Long timestamp;
}