package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.organization.OrganizationResponseDto;

public interface OrganizationService {
    OrganizationResponseDto findById(Integer id);
}
