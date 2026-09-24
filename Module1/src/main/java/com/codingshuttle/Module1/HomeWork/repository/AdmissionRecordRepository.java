package com.codingshuttle.Module1.HomeWork.repository;

import com.codingshuttle.Module1.HomeWork.entity.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, UUID> {
}