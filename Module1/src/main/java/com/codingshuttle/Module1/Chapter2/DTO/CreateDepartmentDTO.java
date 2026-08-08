package com.codingshuttle.Module1.Chapter2.DTO;

import com.codingshuttle.Module1.Chapter2.Annotations.IsActiveValidation;
import com.codingshuttle.Module1.Chapter2.Annotations.PasswordValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentDTO {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "isActive cannot be blank")
    @IsActiveValidation(message = "IsActive can only be \"true\" and \"false\"")
    private Boolean isActive;

    @NotBlank(message = "Password cannot be blank")
    @PasswordValidation(message = "The length of password should be greater than 10, it must contain an Uppercase, a " +
            "lowercase and a special Character")
    private String password;
}
