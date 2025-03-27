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

    private String username;

    private String password;
    private String bodyType;    // ectomorph, mesomorph, endomorph

}
