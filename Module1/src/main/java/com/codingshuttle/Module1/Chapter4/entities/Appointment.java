package com.codingshuttle.Module1.Chapter4.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate;

    private String reason;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient; //Owning Side

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor; //Owning Side
}
