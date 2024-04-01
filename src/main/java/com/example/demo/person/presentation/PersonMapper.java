package com.example.demo.person.presentation;

import com.example.demo.person.domain.entities.Person;
import com.example.demo.person.domain.entities.PersonRol;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public Person fromPersonDTO(PersonDTO personDTO){
        if (personDTO == null)
            return null;
        
        PersonRol personRol = PersonRol.create(personDTO.getIdRol(), null);
        return Person.create(
                personDTO.getId(),
                personDTO.getName(), 
                personDTO.getBirthDate(),
                personRol
        );
    }

    public PersonDTO toPersonDTO(Person person){
        if (person == null)
            return null;
        
        return PersonDTO.create(
                person.getId(),
                person.getName(), 
                person.getBirthDate(),
                person.getRol().getId()
        );
    }
}
