package com.codingshuttle.Module1.Chapter4.repositories;

import com.codingshuttle.Module1.Chapter4.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}