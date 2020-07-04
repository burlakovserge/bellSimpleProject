package ru.bellintegrator.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dto.CitizenshipDto;
import ru.bellintegrator.practice.dto.DocumentDto;
import ru.bellintegrator.practice.service.CatalogueService;

import java.util.List;

@RestController
public class CatalogueController {

    @Autowired
    CatalogueService catalogueService;

    @GetMapping("/api/docs")
    public List<DocumentDto> getDocs(){
        return catalogueService.getAllDocuments();
    }

    @GetMapping("/api/countries")
    public List<CitizenshipDto> getCountries(){
        return catalogueService.getAllCitizenships();
    }
}
