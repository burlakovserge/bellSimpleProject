package ru.bellintegrator.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.person.request.SaveRequestPersonDto;
import ru.bellintegrator.practice.service.PersonService;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public void addPerson(@Valid @RequestBody SaveRequestPersonDto person) {
        service.add(person);
    }

    @GetMapping("/{id}")
    public Dto getPerson(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

}
