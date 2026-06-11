package com.codingshuttle.Module1.Chapter1.Notification_Payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentManager {
    private PaymentService paymentService;

    public PaymentManager(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void Authentic(){
        paymentService.pay("Payment done");
    }
}
