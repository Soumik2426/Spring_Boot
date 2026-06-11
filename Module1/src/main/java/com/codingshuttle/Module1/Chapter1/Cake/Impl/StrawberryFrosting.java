package com.codingshuttle.Module1.Chapter1.Cake.Impl;

import com.codingshuttle.Module1.Chapter1.Cake.Frosting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="frosting.type", havingValue = "strawberry")
public class StrawberryFrosting implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Strawberry Frosting");
    }
}
