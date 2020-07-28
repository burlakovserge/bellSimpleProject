package ru.bellintegrator.practice.dto.person.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.model.Citizenship;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.Office;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePersonDtoMappingId implements Dto {
    private Integer id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private String docName;
    private String docNumber;
    private LocalDate docDate;
    private String citizenshipName;
    private String citizenshipCode;
    private Boolean isIdentified;

}
