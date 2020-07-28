package ru.bellintegrator.practice.dao.citizenship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Citizenship;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CitizenshipDaoImpl implements CitizenshipDao {

    EntityManager em;

    @Autowired
    public CitizenshipDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Citizenship findByCode(String code) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Citizenship> criteriaQuery = cb.createQuery(Citizenship.class);
        Root<Citizenship> citizenship = criteriaQuery.from(Citizenship.class);

        criteriaQuery.select(citizenship);
        criteriaQuery.where(cb.equal(citizenship.get("code"),code));
        TypedQuery<Citizenship> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
}
