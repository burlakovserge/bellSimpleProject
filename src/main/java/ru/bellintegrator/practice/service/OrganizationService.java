package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.OrganizationRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
import ru.bellintegrator.practice.utils.ResponseView;

import java.util.List;

public interface OrganizationService {
    OrganizationResponseDto findById(Integer id);

    ResponseView update(OrganizationRequestDto organization);

    ResponseView save(OrganizationRequestDto organization);

    List<OrganizationResponseDto> getAll();
}
