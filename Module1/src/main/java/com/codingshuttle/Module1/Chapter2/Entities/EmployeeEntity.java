package com.codingshuttle.Module1.Chapter2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="employees",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"Email"}),
                                @UniqueConstraint(columnNames = {"Phn_Number"})},
        indexes = {@Index(name="idx_first_name", columnList = "First_Name"),
                    @Index(name="idx_last_name", columnList = "Last_Name"),
                    @Index(name = "idx_Role", columnList = "Role")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String First_Name;

    @Column(nullable = false)
    private String Last_Name;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Phn_Number;

    @Column(nullable = false)
    private LocalDate Joining_Date;

    @Column(nullable = false)
    private Integer Salary;

    @Column(nullable = false)
    private String Role;

    @Column(nullable = false)
    private Integer YOE;

    @Column(nullable = false)
    private Boolean Active;
}
