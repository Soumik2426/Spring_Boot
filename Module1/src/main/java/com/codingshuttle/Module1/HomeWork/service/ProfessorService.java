package com.codingshuttle.Module1.HomeWork.service;

import com.codingshuttle.Module1.HomeWork.dto.request.ProfessorRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.ProfessorResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ProfessorService {
    ProfessorResponse createProfessor(@Valid ProfessorRequest professorRequest);

    Void deleteProfessor(UUID id);
}
