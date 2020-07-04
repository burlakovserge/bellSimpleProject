package ru.bellintegrator.practice.dao.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Person;

import javax.persistence.EntityManager;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final EntityManager em;

    @Autowired
    public PersonDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Person person) {
        em.persist(person);
    }

    @Override
    public Person loadById(Integer id) {
        return em.find(Person.class, id);
    }
}
