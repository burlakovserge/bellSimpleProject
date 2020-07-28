package ru.bellintegrator.practice.dao.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestOrgDto;
import ru.bellintegrator.practice.dto.person.request.FilterRequestPersonDto;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    public List<Person> getAll(FilterRequestPersonDto filterRequest) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Organization> criteriaQuery = cb.createQuery(Organization.class);
//        Root<Organization> org = criteriaQuery.from(Organization.class);
//
//        criteriaQuery.select(org);
//
//        List<Predicate> list = new ArrayList<>();
//
//        if (filterRequest.getName() != null) {
//            list.add(cb.equal(org.get("name"), filterRequest.getName()));
//        }
//        if (filterRequest.getInn() != null) {
//            list.add(cb.equal(org.get("inn"), filterRequest.getInn()));
//        }
//        if (filterRequest.getIsActive() != null) {
//            list.add(cb.equal(org.get("isActive"), filterRequest.getIsActive()));
//        }
//
//        Predicate[] arr = new Predicate[list.size()];
//        list.toArray(arr);
//        Predicate finalPredicate = cb.and(arr);
//        criteriaQuery.where(finalPredicate);
//
//        return em.createQuery(criteriaQuery).getResultList();
        return null;
    }
}
