package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestDto;
import ru.bellintegrator.practice.utils.ResponseView;

import java.util.List;

public interface OrganizationService {
    Dto findById(Integer id);

    ResponseView update(UpdateRequestDto organization);

    ResponseView save(Dto organization);

    List<Dto> getAll(FilterRequestDto filterRequest);
}
