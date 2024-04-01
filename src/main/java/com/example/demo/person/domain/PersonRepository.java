package com.example.demo.person.domain;

import com.example.demo.person.domain.entities.Person;
import com.example.demo.person.domain.entities.PersonRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    @Query("SELECT p.id as id, p.name as name FROM Person p WHERE p.id = :id")
    PersonIdAndName findIdAndNamePersonById(@Param("id") String id);

    @Query("SELECT r FROM PersonRol r WHERE r.id = :id")
    PersonRol findPersonRolById(@Param("id") Long id);
}
