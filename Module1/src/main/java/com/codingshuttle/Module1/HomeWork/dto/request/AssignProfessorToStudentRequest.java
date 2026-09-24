package com.codingshuttle.Module1.HomeWork.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AssignProfessorToStudentRequest(
        @NotNull(message = "professorId is required")
        UUID professorId
) {
}
