package com.codingshuttle.Module1.Chapter4.repositories;

import com.codingshuttle.Module1.Chapter4.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}