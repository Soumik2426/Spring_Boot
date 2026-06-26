package com.codingshuttle.Module1.Chapter2.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PalindromeValidator implements ConstraintValidator<PalindromeValidation, Integer> {
    @Override
    public boolean isValid(Integer inputValue, ConstraintValidatorContext context) {
        return isPalindrome(inputValue);
    }

    public boolean isPalindrome(Integer inputValue) {
        if(inputValue==null){
            return false;
        }
        int originalValue = inputValue;
        int number=0;
        while(inputValue!=0){
            int a=inputValue%10;
            inputValue=inputValue/10;
            number=(number*10)+a;
        }
        return number==originalValue;
    }
}
