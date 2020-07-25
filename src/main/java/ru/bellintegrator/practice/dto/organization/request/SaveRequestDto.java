package ru.bellintegrator.practice.dto.organization.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.practice.dto.Dto;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class SaveRequestDto implements Dto {

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
