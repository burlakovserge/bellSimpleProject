package ru.bellintegrator.practice.dto.organization.response;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;
import ru.bellintegrator.practice.dto.Dto;

@Builder
@Data
public class OrganizationResponseDto implements Dto {
    @JsonView(ru.bellintegrator.practice.utils.JsonView.List.class)
    private Integer id;

    @JsonView(ru.bellintegrator.practice.utils.JsonView.List.class)
    private String name;

    private String fullname;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    @JsonView(ru.bellintegrator.practice.utils.JsonView.List.class)
    private boolean active;
}
