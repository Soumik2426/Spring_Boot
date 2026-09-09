package com.codingshuttle.Module1.HomeWork.service.impl;

import com.codingshuttle.Module1.HomeWork.dto.request.ProfessorRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.ProfessorResponse;
import com.codingshuttle.Module1.HomeWork.entity.Professor;
import com.codingshuttle.Module1.HomeWork.repository.ProfessorRepository;
import com.codingshuttle.Module1.HomeWork.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    //To create a professor
    @Override
    @Transactional
    public ProfessorResponse createProfessor(ProfessorRequest professorRequest) {
        Professor professor = Professor.builder()
                .title(professorRequest.title())
                .build();

        professor=professorRepository.save(professor);
        return new ProfessorResponse(
                professor.getId(),
                professor.getTitle());
    }

    //To delete a professor
    @Override
    public Void deleteProfessor(UUID id) {
        if(!professorRepository.existsById(id)){
            throw new NoSuchElementException("No professor found with the given id: "+id);
        }

        professorRepository.deleteById(id);
        return null;
    }
}
