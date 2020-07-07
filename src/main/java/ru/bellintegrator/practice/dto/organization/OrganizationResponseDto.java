package ru.bellintegrator.practice.dto.organization;

import lombok.Builder;
import lombok.Data;
import ru.bellintegrator.practice.dto.Dto;

import javax.persistence.Column;

@Builder
@Data
public class OrganizationResponseDto implements Dto {
    private int id;

    private String name;

    private String fullname;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private boolean isActive;
}
