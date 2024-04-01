package com.example.demo.person.application;

import com.example.demo.person.domain.entities.Person;
import com.example.demo.person.domain.PersonRepository;
import com.example.demo.person.domain.useCases.IPersonDeleter;
import com.example.demo.shared.application.errorMessages.PersonErrors;
import com.example.demo.shared.application.exceptions.NotFoundException;
import com.example.demo.shared.application.exceptions.generics.ResourceFail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDeleter implements IPersonDeleter {
    private final PersonRepository repository;
    @Autowired
    public PersonDeleter(PersonRepository repository) {
        this.repository = repository;
    }
    public void delete(String personId){
        final Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isEmpty())
            throw new NotFoundException("id", PersonErrors.NONEXISTENT_PERSON);
        repository.delete(optPerson.get());
    }
}
