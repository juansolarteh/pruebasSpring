package com.example.demo.person.domain.useCases;

import com.example.demo.person.domain.PersonIdAndName;

public interface IPersonIdNameFinder {
    PersonIdAndName findById(String personId);
}
