package com.codingshuttle.Module1.HomeWork.controller;

import com.codingshuttle.Module1.HomeWork.dto.request.SubjectRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.SubjectResponse;
import com.codingshuttle.Module1.HomeWork.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    //To create a subject
    @PostMapping("/create")
    public ResponseEntity<SubjectResponse> createSubject(@RequestBody @Valid SubjectRequest subjectRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subjectService.createSubject(subjectRequest));
    }

    //To delete a subject
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable UUID Id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(subjectService.deleteSubject(Id));
    }
}
