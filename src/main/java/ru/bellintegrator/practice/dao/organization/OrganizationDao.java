package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.model.Organization;

public interface OrganizationDao {
    Organization findById (Integer id);
}
