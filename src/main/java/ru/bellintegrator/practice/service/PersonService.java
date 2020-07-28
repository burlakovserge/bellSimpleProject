package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.person.request.FilterRequestPersonDto;
import ru.bellintegrator.practice.dto.person.request.SaveRequestPersonDto;
import ru.bellintegrator.practice.dto.person.request.UpdateRequestPersonDto;
import ru.bellintegrator.practice.dto.person.response.ResponsePersonDtoMappingList;

import java.util.List;

public interface PersonService {
    /**
     * Добавить нового человека в БД
     *
     * @param person
     */
    void add(SaveRequestPersonDto person);


    /**
     * Найти Person по id
     *
     * @param id - идентификатор
     * @return возвращает объект интерфейса Dto
     */
    Dto findById(Integer id);

    List<ResponsePersonDtoMappingList> getList(FilterRequestPersonDto request);

    void updatePerson(UpdateRequestPersonDto request);
}
