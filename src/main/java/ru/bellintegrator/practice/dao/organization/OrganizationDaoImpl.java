package ru.bellintegrator.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization findById(Integer id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = cb.createQuery(Organization.class);
        Root<Organization> org = criteriaQuery.from(Organization.class);

        criteriaQuery.select(org);
        criteriaQuery.where(cb.equal(org.get("id"), id));
        TypedQuery<Organization> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Organization organization) {
        em.merge(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Organization organization) {
        em.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getAll(FilterRequestDto filterRequest) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = cb.createQuery(Organization.class);
        Root<Organization> org = criteriaQuery.from(Organization.class);

        criteriaQuery.select(org);

        List<Predicate> list = new ArrayList<>();

        if (filterRequest.getName() != null) {
           list.add(cb.equal(org.get("name"), filterRequest.getName()));
        }
        if (filterRequest.getInn() != null) {
            list.add(cb.equal(org.get("inn"), filterRequest.getInn()));
        }
        if (filterRequest.getIsActive() != null) {
            list.add(cb.equal(org.get("isActive"), filterRequest.getIsActive()));
        }

        Predicate[] arr = new Predicate[list.size()];
        list.toArray(arr);
        Predicate finalPredicate = cb.and(arr);
        criteriaQuery.where(finalPredicate);

        return em.createQuery(criteriaQuery).getResultList();
    }
}
