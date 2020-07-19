package ru.bellintegrator.practice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.dto.organization.request.OrganizationRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
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
    public OrganizationResponseDto getOrgById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/update")
    public ResponseView updateOrganization(@Valid @RequestBody OrganizationRequestDto organization) {
        return service.update(organization);
    }

    @PostMapping("/save")
    public ResponseView saveOrganization(@Valid @RequestBody OrganizationRequestDto organization) {
        return service.save(organization);
    }

    @JsonView(ru.bellintegrator.practice.utils.JsonView.List.class)
    @GetMapping("/list")
    public List<OrganizationResponseDto> getAll(){
        return service.getAll();
    }
}
