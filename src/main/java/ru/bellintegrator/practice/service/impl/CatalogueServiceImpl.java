package ru.bellintegrator.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.Factory.CatalogueFactory;
import ru.bellintegrator.practice.dao.сatalogue.CatalogueDao;
import ru.bellintegrator.practice.dto.CitizenshipDto;
import ru.bellintegrator.practice.dto.DocumentDto;
import ru.bellintegrator.practice.service.CatalogueService;

import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    CatalogueDao catalogueDao;
    CatalogueFactory catalogueFactory;

    @Autowired
    public CatalogueServiceImpl(CatalogueDao catalogueDao, CatalogueFactory catalogueFactory) {
        this.catalogueDao = catalogueDao;
        this.catalogueFactory = catalogueFactory;
    }

    @Override
    public List<DocumentDto> getAllDocuments() {
                return catalogueFactory.convertAllDocs(catalogueDao.documentsList());
    }

    @Override
    public List<CitizenshipDto> getAllCitizenships() {
        return catalogueFactory.convertAllCitips(catalogueDao.citizenshipslist());
    }


}
