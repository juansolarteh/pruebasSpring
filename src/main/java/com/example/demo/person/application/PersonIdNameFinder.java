package com.example.demo.person.application;

import com.example.demo.person.domain.PersonIdAndName;
import com.example.demo.person.domain.PersonRepository;
import com.example.demo.person.domain.useCases.IPersonIdNameFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonIdNameFinder implements IPersonIdNameFinder {
    private final PersonRepository repository;
    @Autowired
    public PersonIdNameFinder(PersonRepository repository) {
        this.repository = repository;
    }
    public PersonIdAndName findById(String personId){
        return repository.findIdAndNamePersonById(personId);
    }
}
