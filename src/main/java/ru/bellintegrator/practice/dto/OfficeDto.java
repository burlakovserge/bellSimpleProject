package ru.bellintegrator.practice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OfficeDto implements Dto{
    private int id;
    private String name;
    private String address;
}
