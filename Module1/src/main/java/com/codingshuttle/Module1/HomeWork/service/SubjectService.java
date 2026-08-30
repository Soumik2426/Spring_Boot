package com.codingshuttle.Module1.HomeWork.service;

import com.codingshuttle.Module1.HomeWork.dto.request.SubjectRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.SubjectResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface SubjectService {
    SubjectResponse createSubject(@Valid SubjectRequest subjectRequest);

    Void deleteSubject(UUID id);
}
