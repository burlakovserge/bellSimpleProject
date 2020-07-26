package ru.bellintegrator.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.request.SaveRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestOrgDto;
import ru.bellintegrator.practice.service.OrganizationService;

import javax.validation.Valid;

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
    public void updateOrganization(@Valid @RequestBody UpdateRequestOrgDto organization) {
        service.update(organization);
    }

    @PostMapping("/save")
    public void saveOrganization(@Valid @RequestBody SaveRequestOrgDto organization) {
        service.add(organization);
    }

    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAll(@Valid @RequestBody FilterRequestOrgDto requestDto) {
        return service.getAll(requestDto);
    }
}