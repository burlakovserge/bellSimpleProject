package ru.bellintegrator.practice.dao.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Document;

import javax.persistence.EntityManager;

@Repository
public class DocumentDaoImpl implements DocumentDao {
    private EntityManager em;

    @Autowired
    public DocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addDocument(Document document) {
        em.persist(document);
    }
}
