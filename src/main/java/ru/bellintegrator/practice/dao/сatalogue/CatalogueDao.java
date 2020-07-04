package ru.bellintegrator.practice.dao.сatalogue;

import java.util.List;



public interface CatalogueDao<T> {

    List<T> documentsList();

    List<T> citizenshipslist();
}
