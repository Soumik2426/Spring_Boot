package com.codingshuttle.Module1.Chapter4.entities;

import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String departmentName;

    @OneToOne
    @JoinColumn(name = "deptHeadDoctor", nullable = false)
    private Doctor headDoctor; //Owning Side

    @ManyToMany
    private Set<Doctor> doctors=new HashSet<>();
}
