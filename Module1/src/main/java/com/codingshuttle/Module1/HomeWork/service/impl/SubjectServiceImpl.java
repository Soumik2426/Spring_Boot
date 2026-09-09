package com.codingshuttle.Module1.HomeWork.service.impl;

import com.codingshuttle.Module1.HomeWork.dto.request.SubjectRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.SubjectResponse;
import com.codingshuttle.Module1.HomeWork.entity.Professor;
import com.codingshuttle.Module1.HomeWork.entity.Subject;
import com.codingshuttle.Module1.HomeWork.repository.ProfessorRepository;
import com.codingshuttle.Module1.HomeWork.repository.SubjectRepository;
import com.codingshuttle.Module1.HomeWork.service.SubjectService;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    //To create Subject
    @Override
    @Transactional
    public SubjectResponse createSubject(SubjectRequest subjectRequest, UUID professorId) {
        if(subjectRepository.existsByTitle(subjectRequest.title())){
            throw new DuplicateRequestException("Subject with title already exists");
        }

        Professor professor=professorRepository.findById(professorId)
                .orElseThrow(()->new NoSuchElementException("No professor found with the given Id"));

        Subject subject = Subject.builder()
                .title(subjectRequest.title())
                .professor(professor)
                .build();

        subject=subjectRepository.save(subject);
        return new SubjectResponse(
                subject.getId(),
                subject.getTitle(),
                subject.getProfessor().getId());
    }

    //To delete Subject
    @Override
    public Void deleteSubject(UUID id) {
        if(!subjectRepository.existsById(id)){
            throw new NoSuchElementException("No subject found with the given Id: "+id);
        }
        subjectRepository.deleteById(id);
        return null;
    }
}
