package ru.bellintegrator.practice.dto.organization.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.practice.dto.Dto;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrgDtoMappingId implements Dto {
    private Integer id;

    private String name;

    @Column(name = "full_name")
    private String fullName;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    private Boolean isActive;
}
