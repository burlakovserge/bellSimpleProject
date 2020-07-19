package ru.bellintegrator.practice.Factory;

import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dto.organization.request.OrganizationRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
import ru.bellintegrator.practice.model.Organization;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizationFactory {

    public static OrganizationResponseDto convert(Organization obj) {
        return OrganizationResponseDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .fullname(obj.getFullname())
                .inn(obj.getInn())
                .kpp(obj.getKpp())
                .address(obj.getAddress())
                .phone(obj.getPhone())
                .active(obj.isActive())
                .build();
    }

    public Organization convert(OrganizationRequestDto obj) {
        return new Organization (
                obj.getId(),
                obj.getName(),
                obj.getFullname(),
                obj.getInn(),
                obj.getKpp(),
                obj.getAddress(),
                obj.getPhone(),
                obj.isActive());
    }

    public List<OrganizationResponseDto> getOrgsListDto (List<Organization> org){
        return org.stream().map(OrganizationFactory::convert).collect(Collectors.toList());
    }
}
