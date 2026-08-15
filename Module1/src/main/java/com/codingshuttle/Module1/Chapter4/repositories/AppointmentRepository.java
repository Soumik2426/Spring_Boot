package com.codingshuttle.Module1.Chapter4.repositories;

import com.codingshuttle.Module1.Chapter4.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}