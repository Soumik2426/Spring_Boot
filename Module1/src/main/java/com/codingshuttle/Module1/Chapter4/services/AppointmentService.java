package com.codingshuttle.Module1.Chapter4.services;

import com.codingshuttle.Module1.Chapter4.entities.Appointment;
import com.codingshuttle.Module1.Chapter4.entities.Doctor;
import com.codingshuttle.Module1.Chapter4.entities.Patient;
import com.codingshuttle.Module1.Chapter4.repositories.AppointmentRepository;
import com.codingshuttle.Module1.Chapter4.repositories.DoctorRepository;
import com.codingshuttle.Module1.Chapter4.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    PatientRepository patientRepository;
    DoctorRepository doctorRepository;
    AppointmentRepository appointmentRepository;

    public AppointmentService(PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long patientId, Long DoctorId){
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        Doctor doctor=doctorRepository.findById(DoctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        return appointmentRepository.save(appointment);
    }
}
