package com.codingshuttle.Module1.HomeWork.repository;

import com.codingshuttle.Module1.HomeWork.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    boolean existsByPhnNumber(String phnNumber);
}