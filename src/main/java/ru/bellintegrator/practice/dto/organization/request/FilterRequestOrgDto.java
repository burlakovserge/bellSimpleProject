package ru.bellintegrator.practice.dto.organization.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.practice.dto.Dto;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterRequestOrgDto implements Dto {

    @NotEmpty(message = "please add name value")
    private String name;

    private String inn;

    private Boolean isActive;
}
