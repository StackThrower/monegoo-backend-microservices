package com.monegoo.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class WatcherCleanModel {
    private Integer user;
    private String accessToken;
}
