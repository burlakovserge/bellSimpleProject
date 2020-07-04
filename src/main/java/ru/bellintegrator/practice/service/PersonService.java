package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.PersonDto;

import java.util.List;

public interface PersonService {
    /**
     * Добавить нового человека в БД
     *
     * @param person
     */
     void add(PersonDto person);

     PersonDto findById (Integer id);



}
