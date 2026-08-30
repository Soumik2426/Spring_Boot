package com.codingshuttle.Module1.HomeWork.dto.response;

import java.util.UUID;

public record AssignProfessorToStudentResponse(
        UUID student_id,
        UUID professor_id
) {
}
