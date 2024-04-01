package com.example.demo.person.presentation;

import com.example.demo.person.domain.PersonIdAndName;
import com.example.demo.person.domain.entities.Person;
import com.example.demo.person.domain.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    private final IPersonCreator personCreator;
    private final IPersonDeleter personDeleter;
    private final IPersonFinder personFinder;
    private final IPersonIdNameFinder personIdNameFinder;
    private final IPersonUpdater personUpdater;
    private final PersonMapper mapper;
    @Autowired
    public PersonController(IPersonCreator personCreator, IPersonDeleter personDeleter, IPersonFinder personFinder, IPersonIdNameFinder personIdNameFinder, IPersonUpdater personUpdater, PersonMapper mapper) {
        this.personCreator = personCreator;
        this.personDeleter = personDeleter;
        this.personFinder = personFinder;
        this.personIdNameFinder = personIdNameFinder;
        this.personUpdater = personUpdater;
        this.mapper = mapper;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody @Valid PersonDTO personDTO){
        final Person person = mapper.fromPersonDTO(personDTO);
        personCreator.create(person);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void put(@RequestBody @Valid PersonDTO personDTO){
        final Person person = mapper.fromPersonDTO(personDTO);
        personUpdater.update(person);
    }

    @DeleteMapping("{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String personId){
        personDeleter.delete(personId);
    }

    @GetMapping("{personId}")
    public ResponseEntity<PersonDTO> get(@PathVariable String personId){
        final Person person = personFinder.findById(personId);
        final PersonDTO personDTO = mapper.toPersonDTO(person);
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @GetMapping("summary/{personId}")
    public ResponseEntity<PersonIdNameDTO> getSummary(@PathVariable String personId){
        final PersonIdAndName personIdAndName = personIdNameFinder.findById(personId);
        PersonIdNameDTO personDTO = PersonIdNameDTO.create(personIdAndName.getId(), personIdAndName.getName());
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }
}
