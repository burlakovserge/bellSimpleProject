package ru.bellintegrator.practice.dto.organization.request;

import lombok.Builder;
import lombok.Data;
import ru.bellintegrator.practice.dto.Dto;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class FilterRequestDto implements Dto {

    @NotEmpty(message = "please add name value")
    private String name;

    private String inn;

    private Boolean isActive;
}
