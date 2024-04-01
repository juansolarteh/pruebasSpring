package com.example.demo.person.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "create")
public class PersonIdNameDTO {
    private final String id;
    private final String name;
}
