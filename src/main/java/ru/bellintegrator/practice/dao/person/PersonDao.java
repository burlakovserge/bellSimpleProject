package ru.bellintegrator.practice.dao.person;

import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dto.person.request.FilterRequestPersonDto;
import ru.bellintegrator.practice.model.Person;

import java.util.List;

public interface PersonDao {
    /**
     * Сохранить Person
     *
     * @param person
     */
    void add(Person person);

    /**
     * Получить Person по идентификатору
     *
     * @param id
     * @return
     */
    Person findById(Integer id);

    /**
     * Получить фильтрованный список Person
     *
     * @param request - объект с полями, по которым выполнять фильтрацию
     * @return возвращает список организаций
     */
    List<Person> getAll(FilterRequestPersonDto request);
}
