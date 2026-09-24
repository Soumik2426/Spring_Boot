package com.codingshuttle.Module1.HomeWork.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorRequest(
        @NotBlank(message = "Name is required")
        @Size(max=100, message = "Name cannot exceed 100 characters")
        String title
) {
}
