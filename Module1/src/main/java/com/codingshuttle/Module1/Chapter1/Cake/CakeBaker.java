package com.codingshuttle.Module1.Chapter1.Cake;

import org.springframework.stereotype.Component;

@Component
public class CakeBaker {
    private Frosting frosting;
    private Syrup syrup;


    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakecake(){
        frosting.getFrostingType();
        syrup.getSyrupType();
        System.out.println("Cake Baking....");
    }
}
