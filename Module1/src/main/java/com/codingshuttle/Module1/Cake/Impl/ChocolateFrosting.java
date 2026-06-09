package com.codingshuttle.Module1.Cake.Impl;

import com.codingshuttle.Module1.Cake.Frosting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="frosting.type", havingValue = "chocolate")
public class ChocolateFrosting implements Frosting {
    @Override
    public void getFrostingType() {
        System.out.println("Chocolate Frosting");
    }
}
