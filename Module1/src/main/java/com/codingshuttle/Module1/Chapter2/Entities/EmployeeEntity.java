package com.codingshuttle.Module1.Chapter2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String First_Name;
    private String Last_Name;
    private String Email;
    private String Phn_Number;
    private LocalDate Joining_Date;
    private Integer Salary;
    private String Role;
    private Integer YOE;
    private Boolean Active;
}
