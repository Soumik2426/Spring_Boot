package com.codingshuttle.Module1;

import com.codingshuttle.Module1.Chapter4.entities.Appointment;
import com.codingshuttle.Module1.Chapter4.entities.Insurance;
import com.codingshuttle.Module1.Chapter4.repositories.PatientRepository;
import com.codingshuttle.Module1.Chapter4.services.AppointmentService;
import com.codingshuttle.Module1.Chapter4.services.InsuranceService;
import com.codingshuttle.Module1.Chapter4.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class CascadeTest {
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;

    @Test
    void contextLoads() {
    }

    @Test
    public void Test1(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC003451")
                .provider("HDFC")
                .validUntil(LocalDate.of(2035,5,1))
                .build();

        var updatedInsurance=insuranceService.assignInsurance(insurance, 1L);
        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void Test2(){
        Appointment appointment=Appointment.builder()
                .appointmentDate(LocalDateTime.of(2026,8,18,12,0,0))
                .reason("Migrain & Headache")
                .build();
        var newAppointment=appointmentService.createAppointment(appointment,5L,2L);
        System.out.println(newAppointment);

        patientService.deletePatient(5L);
    }

    @Test
    public void Test(){
        var patient=patientService.findPatientById(5L);
        System.out.println(patient);
    }
}
