package com.fitness.model;

import lombok.*;
import jakarta.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String bodyType;    // ectomorph, mesomorph, endomorph

    private double height;      // In cenimeters or inches
    private double weight;      // In kilograms or pounds
    private String goal;       // bulk, cut, maintain

}
