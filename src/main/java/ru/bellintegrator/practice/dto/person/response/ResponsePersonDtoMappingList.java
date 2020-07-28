package ru.bellintegrator.practice.dto.person.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.practice.dto.Dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePersonDtoMappingList implements Dto {
    private Integer id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
}
