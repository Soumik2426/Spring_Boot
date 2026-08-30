package com.codingshuttle.Module1.HomeWork.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;

import java.util.UUID;

@Entity
@Table(name = "admission_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name ="fees", nullable = false)
    private Integer fees;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

}
