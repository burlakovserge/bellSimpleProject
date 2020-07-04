package ru.bellintegrator.practice.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class OrganizationDto implements Dto{
    private int id;

    private String name;

    private String fullname;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private boolean isActive;
}
