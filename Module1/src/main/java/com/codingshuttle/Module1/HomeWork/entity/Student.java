package com.codingshuttle.Module1.HomeWork.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phn_number", nullable = false, length = 20, unique = true)
    private String phnNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Professor> professors;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Subject> subjects;

    @OneToOne(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private AdmissionRecord admissionRecord;
}
