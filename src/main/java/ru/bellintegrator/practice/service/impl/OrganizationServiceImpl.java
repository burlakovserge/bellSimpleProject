package ru.bellintegrator.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.Factory.OrganizationFactory;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.dto.organization.request.OrganizationRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
import ru.bellintegrator.practice.utils.ResponseView;
import ru.bellintegrator.practice.service.OrganizationService;

import javax.transaction.Transactional;
import java.util.List;

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
    public OrganizationResponseDto findById(Integer id) {
        return OrganizationFactory.convert(dao.findById(id));
    }

    @Override
    @Transactional
    public ResponseView update(OrganizationRequestDto organization) {
                 dao.update(factory.convert(organization));
        return new ResponseView("success");
    }

    @Override
    @Transactional
    public ResponseView save(OrganizationRequestDto organization) {
        dao.save(factory.convert(organization));
        return new ResponseView("success");
    }

    @Override
    public List<OrganizationResponseDto> getAll() {

        return factory.getOrgsListDto(dao.getAll());
    }
}
