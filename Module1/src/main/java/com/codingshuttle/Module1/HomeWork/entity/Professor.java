package com.codingshuttle.Module1.HomeWork.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "professors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Professor extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "professor_name", nullable = false, length = 100)
    private String title;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<Subject> subjects;

    @ManyToMany(mappedBy = "professors", fetch = FetchType.LAZY)
    private List<Student> students;
}
