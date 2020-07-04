package ru.bellintegrator.practice.Factory;

import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.OfficeDto;
import ru.bellintegrator.practice.model.Office;

@Component
public class OfficeFactory  {

    public OfficeDto convert(Office obj) {
        return OfficeDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .address(obj.getAddress())
                .build();
    }
}
