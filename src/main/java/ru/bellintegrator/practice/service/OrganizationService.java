package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto findById(Integer id);
}
