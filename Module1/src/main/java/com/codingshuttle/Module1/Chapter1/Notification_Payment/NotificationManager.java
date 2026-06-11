package com.codingshuttle.Module1.Chapter1.Notification_Payment;

import org.springframework.stereotype.Component;

@Component
public class NotificationManager {
    private NotificationService notificationService;

    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void success(){
        notificationService.send("Message");
    }
}
