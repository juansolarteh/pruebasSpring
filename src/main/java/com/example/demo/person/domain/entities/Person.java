package com.example.demo.person.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person {
    @Id
    private String id;
    private String name;
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private PersonRol rol;
}
