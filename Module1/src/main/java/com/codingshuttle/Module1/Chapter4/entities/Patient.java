package com.codingshuttle.Module1.Chapter4.entities;

import com.codingshuttle.Module1.Chapter4.entities.type.BloodGroupType;
import com.codingshuttle.Module1.Chapter4.entities.type.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType  bloodGroupType;

    private LocalDateTime createdDate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "patient_insurance", unique = true)
    private Insurance insurance; //Owning Side

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "patient")
    private Set<Appointment> appointments=new HashSet<>(); //Inverse Side
}
