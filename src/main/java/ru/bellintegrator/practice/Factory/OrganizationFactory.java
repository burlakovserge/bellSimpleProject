package ru.bellintegrator.practice.Factory;

import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dto.organization.OrganizationResponseDto;
import ru.bellintegrator.practice.model.Organization;

@Component
public class OrganizationFactory {

    public OrganizationResponseDto convert(Organization obj) {
        return OrganizationResponseDto.builder()
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
