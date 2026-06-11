package com.codingshuttle.Module1.Chapter1.Notification_Payment.Impl;

import com.codingshuttle.Module1.Chapter1.Notification_Payment.NotificationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="notification.type", havingValue = "whatsapp")
public class WhatsappService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println(message+" sent through Whatsapp");
    }
}
