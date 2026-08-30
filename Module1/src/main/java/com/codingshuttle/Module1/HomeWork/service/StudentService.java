package com.codingshuttle.Module1.HomeWork.service;

import com.codingshuttle.Module1.HomeWork.dto.request.AssignProfessorToStudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.AssignSubjectToStudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.StudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.AssignProfessorToStudentResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.AssignSubjectToStudentResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.StudentResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface StudentService {
    StudentResponse createStudent(@Valid StudentRequest studentRequest);

    Void deleteStudent(UUID id);

    AssignProfessorToStudentResponse assignProfessor(UUID studentId, @Valid AssignProfessorToStudentRequest assignProfessorToStudentRequest);

    AssignSubjectToStudentResponse assignSubject(UUID studentId, @Valid AssignSubjectToStudentRequest assignSubjectToStudentRequest);
}
