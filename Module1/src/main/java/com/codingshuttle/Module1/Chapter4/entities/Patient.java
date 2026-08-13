package com.codingshuttle.Module1.Chapter4.entities;

import com.codingshuttle.Module1.Chapter4.entities.type.BloodGroupType;
import com.codingshuttle.Module1.Chapter4.entities.type.Gender;
import jakarta.persistence.*;
import lombok.*;

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
@ToString
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

    @OneToOne
    private Insurance insurance; //Owning Side

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments=new HashSet<>(); //Inverse Side
}
