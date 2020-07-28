package ru.bellintegrator.practice.dto.person.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.model.Citizenship;
import ru.bellintegrator.practice.model.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestPersonDto implements Dto {
    @Min(value = 1, message = "please add office id value")
    private Integer id;

    @NotEmpty(message = "please add first name value")
    private String firstName;
    private String secondName;
    private String middleName;

    @NotEmpty(message = "please add position value")
    private String position;

    private String phone;
    private String docNumber;
    private LocalDate docDate;
    private String citizenshipCode;
    private Boolean isIdentified;
}
