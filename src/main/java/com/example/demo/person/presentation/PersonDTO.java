package com.example.demo.person.presentation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(staticName = "create")
public class PersonDTO {
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Long idRol;

    @JsonIgnore
    @AssertTrue(message = "$%birthDate:La persona debe ser mayor de edad")
    public boolean isAdult() {
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.minusYears(birthDate.getYear()).getYear();
        return age >= 18;
    }
}
