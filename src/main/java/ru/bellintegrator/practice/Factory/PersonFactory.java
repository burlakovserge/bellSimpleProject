package ru.bellintegrator.practice.Factory;

import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.PersonDto;
import ru.bellintegrator.practice.model.Person;

@Component
public class PersonFactory {

    public PersonDto convertToDto(Person obj) {
        return PersonDto.builder()
                .id(obj.getId())
                .firstName(obj.getFirstName())
                .workPosition(obj.getWorkPosition())
                .build();
    }

    public Person convertFromDto(PersonDto personDto) {
        return new Person(
//                personDto.getId(),
//                personDto.getFirstName(),
//                personDto.getSecondName(),
//                personDto.getMiddleName(),
//                personDto.getPhone(),
//                personDto.getWorkPosition(),
//                personDto.getDocuments(),
//                personDto.getDocNumber(),
//                personDto.getDocDate(),
//                personDto.getCitizenships(),
//                personDto.isIdentified()
        );
    }
}
