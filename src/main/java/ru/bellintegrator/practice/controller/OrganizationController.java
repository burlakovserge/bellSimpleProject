package ru.bellintegrator.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dto.organization.request.OrganizationRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
import ru.bellintegrator.practice.service.OrganizationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    OrganizationService service;

    @GetMapping("/{id}")
    public OrganizationResponseDto getOrgById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity updateOrganization(@Valid @RequestBody OrganizationRequestDto organization) {
        service.update(organization);
        return new ResponseEntity<>("{result: success}", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity saveOrganization(@Valid @RequestBody OrganizationRequestDto organization) {
        service.save(organization);
        return new ResponseEntity<>("{result: success}", HttpStatus.OK);
    }
}
