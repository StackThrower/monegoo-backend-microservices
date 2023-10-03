package com.monegoo.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DeviceModel {
    private Integer id;
    private String pushToken;
    private String accessToken;
}
