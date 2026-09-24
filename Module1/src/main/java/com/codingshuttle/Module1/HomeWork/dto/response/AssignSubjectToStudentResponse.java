package com.codingshuttle.Module1.HomeWork.dto.response;

import java.util.UUID;

public record AssignSubjectToStudentResponse(
        UUID student_Id,
        UUID subject_Id
) {
}
