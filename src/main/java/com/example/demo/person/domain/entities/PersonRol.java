package com.example.demo.person.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonRol {
    @Id
    private Long id;
    private String name;
}
