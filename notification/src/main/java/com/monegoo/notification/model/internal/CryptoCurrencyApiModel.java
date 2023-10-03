package com.monegoo.notification.model.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptoCurrencyApiModel {

    private CryptoCurrenciesApiModel data;
    private Long timestamp;
}