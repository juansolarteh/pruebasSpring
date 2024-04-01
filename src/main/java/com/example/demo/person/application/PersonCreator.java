package com.example.demo.person.application;

import com.example.demo.person.domain.PersonRepository;
import com.example.demo.person.domain.entities.Person;
import com.example.demo.person.domain.useCases.IPersonCreator;
import com.example.demo.shared.application.errorMessages.PersonErrors;
import com.example.demo.shared.application.exceptions.ExistingResourceException;
import com.example.demo.shared.application.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCreator implements IPersonCreator {
    private final PersonRepository repository;
    @Autowired
    public PersonCreator(PersonRepository repository) {
        this.repository = repository;
    }

    public void create(Person person){
        if (repository.findById(person.getId()).isPresent())
            throw new ExistingResourceException("id", PersonErrors.EXISTENT_PERSON);

        if (repository.findPersonRolById(person.getRol().getId()) == null)
            throw new NotFoundException("idRol", PersonErrors.NONEXISTENT_ROL);

        repository.save(person);
    }
}
