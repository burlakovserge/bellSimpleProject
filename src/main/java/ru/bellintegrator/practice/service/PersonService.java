package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.person.request.SaveRequestPersonDto;

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
}
