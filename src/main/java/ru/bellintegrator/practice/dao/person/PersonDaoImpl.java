package ru.bellintegrator.practice.dao.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dto.person.request.FilterRequestPersonDto;
import ru.bellintegrator.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final EntityManager em;

    @Autowired
    public PersonDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Person person) {
        em.persist(person);
    }

    @Override
    public Person findById(Integer id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
        Root<Person> person = criteriaQuery.from(Person.class);

        criteriaQuery.select(person);
        criteriaQuery.where(cb.equal(person.get("id"), id));
        TypedQuery<Person> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }

    @Override
    public List<Person> getList(FilterRequestPersonDto filterRequest) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
        Root<Person> org = criteriaQuery.from(Person.class);
        Predicate office_id = cb.equal(org.get("office"), filterRequest.getOfficeId());
        criteriaQuery.where(cb.and(office_id));
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void update(Person person) {
        em.merge(person);
    }


}
