package com.codingshuttle.Module1.Chapter2.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext context) {
        if(inputValue==null){
            return false;
        }
        List<String> roles=List.of("USER", "ADMIN");
        return roles.contains(inputValue);
    }
}
