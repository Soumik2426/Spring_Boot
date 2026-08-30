package com.codingshuttle.Module1.HomeWork.repository;

import com.codingshuttle.Module1.HomeWork.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}