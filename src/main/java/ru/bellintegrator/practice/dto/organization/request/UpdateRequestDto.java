package ru.bellintegrator.practice.dto.organization.request;

import lombok.Builder;
import lombok.Data;
import ru.bellintegrator.practice.dto.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class UpdateRequestDto implements Dto {
    @Min(value = 1, message = "please add id value")
    private Integer id;

    @NotEmpty(message = "please add name value")
    private String name;

    @NotEmpty(message = "please add full name value")
    private String fullName;

    @NotEmpty(message = "please add inn value")
    private String inn;

    @NotEmpty(message = "please add kpp value")
    private String kpp;

    @NotEmpty(message = "please add address value")
    private String address;

    private String phone;

    private Boolean isActive;
}
