package com.codingshuttle.Module1.Notification_Payment.Impl;

import com.codingshuttle.Module1.Notification_Payment.NotificationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
//@Primary
@ConditionalOnProperty(name="notification.type", havingValue = "email")
public class EmailService implements NotificationService {
    @Override
    public void send(String message){
        System.out.println(message+" sent through Email");
    }
}
