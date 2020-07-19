package ru.bellintegrator.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Organization findById(Integer id) {
        return em.find(Organization.class, id);
    }

    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public List<Organization> getAll() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }
}
