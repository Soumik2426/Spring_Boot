package com.codingshuttle.Module1.Chapter1.Cake.Impl;

import com.codingshuttle.Module1.Chapter1.Cake.Syrup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="syrup.type", havingValue = "strawberry")
public class StrawberrySyrup implements Syrup {
    @Override
    public void getSyrupType() {
        System.out.println("Strawberry Syrup");
    }
}
