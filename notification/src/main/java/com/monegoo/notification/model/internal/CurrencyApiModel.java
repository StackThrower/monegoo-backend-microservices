package com.monegoo.notification.model.internal;

import com.monegoo.notification.model.internal.CurrenciesApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyApiModel {

    private CurrenciesApiModel data;
    private Long timestamp;
}