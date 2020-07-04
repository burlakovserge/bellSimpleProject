package ru.bellintegrator.practice.Factory;

import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.OfficeDto;
import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;

@Component
public class OrganizationFactory {

    public OrganizationDto convert(Organization obj) {
        return OrganizationDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .fullname(obj.getFullname())
                .inn(obj.getInn())
                .kpp(obj.getKpp())
                .address(obj.getAddress())
                .phone(obj.getPhone())
                .isActive(obj.isActive())
                .build();
    }
}
