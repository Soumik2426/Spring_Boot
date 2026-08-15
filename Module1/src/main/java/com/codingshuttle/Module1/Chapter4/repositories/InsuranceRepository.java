package com.codingshuttle.Module1.Chapter4.repositories;

import com.codingshuttle.Module1.Chapter4.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}