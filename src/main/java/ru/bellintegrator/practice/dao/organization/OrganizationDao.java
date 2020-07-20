package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.model.Organization;

import java.util.List;

public interface OrganizationDao {
    Organization findById (Integer id);

    void update (Organization organization);

    void save (Organization organization);

    List<Organization> getAll(FilterRequestDto filterRequest);
}
