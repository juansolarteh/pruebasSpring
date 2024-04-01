package com.example.demo.person.application;

import com.example.demo.person.domain.entities.Person;
import com.example.demo.person.domain.PersonRepository;
import com.example.demo.person.domain.useCases.IPersonUpdater;
import com.example.demo.shared.application.errorMessages.PersonErrors;
import com.example.demo.shared.application.exceptions.NotFoundException;
import com.example.demo.shared.application.exceptions.generics.ResourceFail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonUpdater implements IPersonUpdater {
    private final PersonRepository repository;
    @Autowired
    public PersonUpdater(PersonRepository repository) {
        this.repository = repository;
    }
    public void update(Person person){
        final Optional<Person> optPerson = repository.findById(person.getId());
        if (optPerson.isEmpty())
            throw new NotFoundException("id", PersonErrors.NONEXISTENT_PERSON);
        repository.save(person);
    }
}
