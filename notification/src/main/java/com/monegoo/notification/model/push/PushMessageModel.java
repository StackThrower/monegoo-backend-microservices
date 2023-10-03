package com.monegoo.notification.model.push;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PushMessageModel {
    private String to;
    private PushNotificationModel notification;
}
