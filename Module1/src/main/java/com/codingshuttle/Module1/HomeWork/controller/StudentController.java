package com.codingshuttle.Module1.HomeWork.controller;

import com.codingshuttle.Module1.HomeWork.dto.request.AssignProfessorToStudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.AssignSubjectToStudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.StudentRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.AssignProfessorToStudentResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.AssignSubjectToStudentResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.StudentResponse;
import com.codingshuttle.Module1.HomeWork.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    //Creating Student
    @PostMapping("/create")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(studentRequest));
    }

    //Deleting Student
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID Id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.deleteStudent(Id));
    }

    //To assign professor to student
    @PostMapping("/assignProfessor/{studentId}")
    public ResponseEntity<AssignProfessorToStudentResponse> assignProfessor(@PathVariable UUID studentId, @RequestBody @Valid AssignProfessorToStudentRequest assignProfessorToStudentRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.assignProfessor(studentId, assignProfessorToStudentRequest));
    }

    //To assign subject to Student
    @PostMapping("/assignSubject/{studentId}")
    public ResponseEntity<AssignSubjectToStudentResponse> assignSubject(@PathVariable UUID studentId, @RequestBody @Valid AssignSubjectToStudentRequest assignSubjectToStudentRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.assignSubject(studentId, assignSubjectToStudentRequest));
    }
}
