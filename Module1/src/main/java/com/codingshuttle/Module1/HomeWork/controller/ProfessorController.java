package com.codingshuttle.Module1.HomeWork.controller;

import com.codingshuttle.Module1.HomeWork.dto.request.ProfessorRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.ProfessorResponse;
import com.codingshuttle.Module1.HomeWork.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    //To create a professor
    @PostMapping("/create")
    public ResponseEntity<ProfessorResponse> createProfessor(@RequestBody @Valid ProfessorRequest professorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(professorService.createProfessor(professorRequest));
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable UUID Id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(professorService.deleteProfessor(Id));
    }
}
