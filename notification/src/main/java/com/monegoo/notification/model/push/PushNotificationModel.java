package com.monegoo.notification.model.push;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PushNotificationModel {
    private String body;
    private String priority;
    private String title;
}
