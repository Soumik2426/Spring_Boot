package com.codingshuttle.Module1.HomeWork.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SubjectRequest(
        @NotNull(message = "Title is required")
        @Size(max = 100, message = "Title cannot exceed 100 characters")
        String title
) {
}
