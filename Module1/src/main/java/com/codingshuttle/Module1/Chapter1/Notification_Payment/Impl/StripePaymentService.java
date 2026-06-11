package com.codingshuttle.Module1.Chapter1.Notification_Payment.Impl;

import com.codingshuttle.Module1.Chapter1.Notification_Payment.PaymentService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
//@Primary
@ConditionalOnProperty(name="payment.type", havingValue = "stripe")
public class StripePaymentService implements PaymentService {
    @Override
    public void pay(String message) {
        System.out.println(message+" using Stripe");
    }
}
