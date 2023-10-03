package com.monegoo.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WatcherModel {
    private Integer id;
    private Integer user;
    private String accessToken;
    private String code;
    private BigDecimal min;
    private BigDecimal max;
    private Boolean enabled;
}
