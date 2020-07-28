package ru.bellintegrator.practice.dao.сatalogue;

import ru.bellintegrator.practice.model.CatalogueDocInfo;

public interface CatalogueDocInfoDao {

    CatalogueDocInfo findByCode(String code);
}
