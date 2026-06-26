package com.codingshuttle.Module1.Chapter2.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class IsActiveValidator implements ConstraintValidator<IsActiveValidation, String> {


    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext context) {
        if(inputValue==null){
            return false;
        }
        List<String> status=List.of("true", "false");
        return status.contains(inputValue.toString());
    }
}
