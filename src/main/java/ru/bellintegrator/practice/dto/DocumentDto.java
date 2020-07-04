package ru.bellintegrator.practice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DocumentDto implements Dto {
    private String name;
    private Short code;
}
