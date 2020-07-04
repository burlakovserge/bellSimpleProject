package ru.bellintegrator.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dto.PersonDto;
import ru.bellintegrator.practice.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public ResponseEntity person(@RequestBody PersonDto person) {
        personService.add(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id){
        return new ResponseEntity(personService.findById(id), HttpStatus.OK);
    }

}
