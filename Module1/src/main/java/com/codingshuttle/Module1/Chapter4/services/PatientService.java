package com.codingshuttle.Module1.Chapter4.services;

import com.codingshuttle.Module1.Chapter4.entities.Patient;
import com.codingshuttle.Module1.Chapter4.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void deletePatient(Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        patientRepository.delete(patient);
    }

    @Transactional
    public Patient findPatientById(Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        return patient;
    }
}
