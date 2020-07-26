package ru.bellintegrator.practice.dto.organization.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.practice.dto.Dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrgDtoMappingList implements Dto {
    private Integer id;

    private String name;

    private Boolean isActive;
}
