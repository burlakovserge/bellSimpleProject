package ru.bellintegrator.practice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CitizenshipDto implements Dto {
    @JsonProperty("country")
    private String name;

    private Short code;
}
