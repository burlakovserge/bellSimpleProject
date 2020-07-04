package ru.bellintegrator.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.Factory.OrganizationFactory;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.dto.OrganizationDto;
import ru.bellintegrator.practice.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    OrganizationDao dao;
    OrganizationFactory factory;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, OrganizationFactory factory) {
        this.dao = dao;
        this.factory = factory;
    }

    @Override
    public OrganizationDto findById(Integer id) {
        return factory.convert(dao.findById(id));
    }
}
