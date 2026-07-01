package com.codingshuttle.Module1.Chapter2.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeValidator implements ConstraintValidator<PrimeValidation, Integer> {
    @Override
    public boolean isValid(Integer inputValue, ConstraintValidatorContext context) {
        return isPrime(inputValue);
    }
    public boolean isPrime(Integer inputValue) {
        for(int i=2;i<inputValue;i++){
            if(inputValue%i==0){
                return false;
            }
        }
        return true;
    }
}
