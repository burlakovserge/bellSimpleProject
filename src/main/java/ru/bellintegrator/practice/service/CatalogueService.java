package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.CitizenshipDto;
import ru.bellintegrator.practice.dto.DocumentDto;

import java.util.List;

public interface CatalogueService {

     List<DocumentDto> getAllDocuments();

     List<CitizenshipDto> getAllCitizenships();
}
