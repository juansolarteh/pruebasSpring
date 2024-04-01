package com.example.demo.person.domain.useCases;

import com.example.demo.person.domain.entities.Person;

public interface IPersonFinder {
    Person findById(String personId);
}
