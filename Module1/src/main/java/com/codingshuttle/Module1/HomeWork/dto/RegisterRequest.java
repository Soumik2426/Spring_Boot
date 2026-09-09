package com.codingshuttle.Module1.HomeWork.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank(message="First Name is required")
    @Size(max=100)
    private String firstName;

    @NotBlank(message="Last Name is required")
    @Size(max=100)
    private String lastName;

    @NotBlank(message="Email is required")
    /*@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$",
            message = "Email must end with a valid domain(e.g: .com, .org)")*/
    @Email(message = "Provide a valid email format")
    private String email;

    @NotBlank(message="Password is required")
    private String password;
}
