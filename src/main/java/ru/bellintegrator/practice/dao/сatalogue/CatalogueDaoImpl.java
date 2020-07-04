package ru.bellintegrator.practice.dao.сatalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Citizenship;
import ru.bellintegrator.practice.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CatalogueDaoImpl implements CatalogueDao {
    private final EntityManager em;

    @Autowired
    public CatalogueDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Document> documentsList() {
        TypedQuery<Document> query = em.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }

    @Override
    public List<Citizenship> citizenshipslist() {
        TypedQuery<Citizenship> query = em.createQuery("SELECT c FROM Citizenship c", Citizenship.class);
        return query.getResultList();
    }
}
