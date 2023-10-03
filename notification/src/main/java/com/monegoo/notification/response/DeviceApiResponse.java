package com.monegoo.notification.response;

import lombok.Data;

@Data
public class DeviceApiResponse {
    private Integer id;
    private String pushToken;
    private String accessToken;
}
