package ru.bellintegrator.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.service.OrganizationService;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    OrganizationService service;

    @GetMapping("/{id}")
    public OrganizationDto getOrgById (@PathVariable("id") Integer id){
        return service.findById(id);
    }
}
