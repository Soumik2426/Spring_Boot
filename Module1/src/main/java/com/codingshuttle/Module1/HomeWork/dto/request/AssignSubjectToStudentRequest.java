package com.codingshuttle.Module1.HomeWork.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AssignSubjectToStudentRequest(
        @NotNull(message = "subjectId is required")
        UUID subjectId
) {
}
