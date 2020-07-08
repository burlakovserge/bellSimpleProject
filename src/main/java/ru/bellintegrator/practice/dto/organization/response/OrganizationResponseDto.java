package ru.bellintegrator.practice.dto.organization.response;

import lombok.Builder;
import lombok.Data;
import ru.bellintegrator.practice.dto.Dto;

@Builder
@Data
public class OrganizationResponseDto implements Dto {
    private Integer id;

    private String name;

    private String fullname;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private boolean isActive;
}
