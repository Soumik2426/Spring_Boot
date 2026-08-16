package com.codingshuttle.Module1.Chapter4.services;

import com.codingshuttle.Module1.Chapter4.entities.Insurance;
import com.codingshuttle.Module1.Chapter4.entities.Patient;
import com.codingshuttle.Module1.Chapter4.repositories.InsuranceRepository;
import com.codingshuttle.Module1.Chapter4.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Builder
@ToString
public class InsuranceService {
    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    public InsuranceService(InsuranceRepository insuranceRepository, PatientRepository patientRepository) {
        this.insuranceRepository = insuranceRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Insurance assignInsurance(Insurance insurance, Long PatientId){
        Patient patient=patientRepository.findById(PatientId).orElseThrow();
        patient.setInsurance(insurance);
        return insurance;
    }

    @Transactional
    public Insurance updateInsurance(Insurance insurance, Long PatientId){
        Patient patient=patientRepository.findById(PatientId).orElseThrow();
        patient.setInsurance(insurance);
        return insurance;
    }

    @Transactional
    public Patient removeInsurance(Long PatientId){
        Patient patient=patientRepository.findById(PatientId).orElseThrow();
        patient.setInsurance(null);
        return patient;
    }
}
