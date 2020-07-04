package ru.bellintegrator.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.bellintegrator.practice.model.Citizenship;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.Office;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
public class PersonDto implements Dto{
    private Integer id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private String workPosition;
    private Set<Document> documents;
    private String docNumber;
    private LocalDate docDate;
    private Set<Citizenship> citizenships;
    private boolean isIdentified;


}
