package ru.bellintegrator.practice.dao.person;

import ru.bellintegrator.practice.model.Person;

public interface PersonDao {
    /**
     * Сохранить Person
     *
     * @param person
     */
    void save(Person person);

    /**
     * Получить Person по идентификатору
     *
     * @param id
     * @return
     */
    Person loadById(Integer id);
}
