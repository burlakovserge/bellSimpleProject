package ru.bellintegrator.practice.dao.сatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.CatalogueDocInfo;
import ru.bellintegrator.practice.model.Citizenship;
import ru.bellintegrator.practice.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CatalogueDocInfoDaoImpl implements CatalogueDocInfoDao {
    private final EntityManager em;

    @Autowired
    public CatalogueDocInfoDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public CatalogueDocInfo findByCode(String code) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CatalogueDocInfo> criteriaQuery = cb.createQuery(CatalogueDocInfo.class);
        Root<CatalogueDocInfo> catalogueDocInfo = criteriaQuery.from(CatalogueDocInfo.class);

        criteriaQuery.select(catalogueDocInfo);
        criteriaQuery.where(cb.equal(catalogueDocInfo.get("code"), code));
        TypedQuery<CatalogueDocInfo> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
}
