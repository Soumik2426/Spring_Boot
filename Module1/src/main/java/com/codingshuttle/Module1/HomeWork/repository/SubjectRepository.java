package com.codingshuttle.Module1.HomeWork.repository;

import com.codingshuttle.Module1.HomeWork.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    boolean existsByTitle(String title);
}