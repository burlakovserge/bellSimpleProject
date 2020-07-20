package ru.bellintegrator.practice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestDto;
import ru.bellintegrator.practice.dto.organization.request.SaveRequestDto;
import ru.bellintegrator.practice.utils.ResponseView;
import ru.bellintegrator.practice.service.OrganizationService;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Dto getById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public ResponseView updateOrganization(@Valid @RequestBody UpdateRequestDto organization) {
        if (organization.getId() != null) {
            return service.update(organization);
        } else return new ResponseView("Не указан Id. Операция не выполнена");
    }

    @PostMapping("/save")
    public ResponseView saveOrganization(@Valid @RequestBody SaveRequestDto organization) {
        return service.save(organization);
    }

    @JsonView(ru.bellintegrator.practice.utils.JsonView.List.class)
    @PostMapping("/list")
    public List<Dto> getAll(@Valid @RequestBody FilterRequestDto requestDto) {
        return service.getAll(requestDto);
    }
}
