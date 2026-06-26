package com.codingshuttle.Module1.Chapter2.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsActiveValidator.class})
public @interface IsActiveValidation {
    String message() default "{jakarta.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
