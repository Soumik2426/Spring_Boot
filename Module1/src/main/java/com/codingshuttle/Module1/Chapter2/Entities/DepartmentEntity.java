package com.codingshuttle.Module1.Chapter2.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="department",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})},
        indexes = {@Index(name="idx_title", columnList = "title")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
