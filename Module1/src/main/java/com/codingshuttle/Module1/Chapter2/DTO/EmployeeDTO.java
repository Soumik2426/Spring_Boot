package com.codingshuttle.Module1.Chapter2.DTO;

import com.codingshuttle.Module1.Chapter2.Annotations.EmployeeRoleValidation;
import com.codingshuttle.Module1.Chapter2.Annotations.PalindromeValidation;
import com.codingshuttle.Module1.Chapter2.Annotations.PrimeValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "It cannot be blank")
    private String First_Name;

    @NotBlank(message = "It cannot be blank")
    @NotEmpty(message="Last name cannot be Empty")
    private String Last_Name;

    @NotBlank(message = "It cannot be blank")
    @Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Provide a valid email address")
    private String Email;

    @NotBlank(message = "It cannot be blank")
    @Pattern(regexp = "^(?:\\+91|91)?[6-9]\\d{9}$", message = "Give a proper mobile number")
    private String Phn_Number;

    @NotNull(message = "It cannot be Null")
    @Max(value = 23000, message = "Salary cannot be more than 23000")
    @Positive(message="The salary has to be greater than zero")
    @PalindromeValidation(message = "Salary has to be a palindrome number")
    private Integer Salary;

    @NotNull(message = "YOE cannot be null")
    @PrimeValidation(message = "YOE has to be a prime number")
    private Integer YOE;

    @NotBlank(message = "It cannot become null")
    @EmployeeRoleValidation(message = "Role could either be USER or ADMIN")
    private String Role;

    @NotNull(message = "It cannot be Null")
    @FutureOrPresent(message = "Joining Date should be a future one or Present One")
    private LocalDate Joining_Date;

    @NotNull(message = "It cannot be Null")
    @AssertTrue(message = "The Active should always be true")
    private Boolean Active;
}
