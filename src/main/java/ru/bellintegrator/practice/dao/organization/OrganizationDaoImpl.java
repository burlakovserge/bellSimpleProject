package ru.bellintegrator.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
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
    public List<Organization> getAll(FilterRequestDto filterRequest) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> q = cb.createQuery(Organization.class);
        Root<Organization> c = q.from(Organization.class);

        q.select(c);
        ParameterExpression<String> name = cb.parameter(String.class);
        ParameterExpression<String> inn = cb.parameter(String.class);
        ParameterExpression<Boolean> active = cb.parameter(Boolean.class);
        q.where( cb.equal(c.get("name"), name),
                cb.or(
                        cb.equal(c.get("inn"), inn),
                        cb.equal(c.get("active"), active)
                )
        );

        TypedQuery<Organization> list = em.createQuery(q);
        list.setParameter(name, filterRequest.getName());
        list.setParameter(inn, filterRequest.getInn());
        list.setParameter(active, filterRequest.isActive());
        return list.getResultList();
    }
}
