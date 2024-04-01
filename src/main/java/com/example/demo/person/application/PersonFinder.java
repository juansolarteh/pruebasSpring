package com.example.demo.person.application;

import com.example.demo.person.domain.entities.Person;
import com.example.demo.person.domain.PersonRepository;
import com.example.demo.person.domain.useCases.IPersonFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonFinder implements IPersonFinder {
    private final PersonRepository repository;
    @Autowired
    public PersonFinder(PersonRepository repository) {
        this.repository = repository;
    }
    public Person findById(String personId){
        final Optional<Person> optPerson = repository.findById(personId);
        return optPerson.orElse(null);
    }
}
