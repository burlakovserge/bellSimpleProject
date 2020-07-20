package ru.bellintegrator.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.Factory.OrganizationFactory;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.dto.organization.request.SaveRequestDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.utils.ResponseView;

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
    public Dto findById(Integer id) {
        return OrganizationFactory.convert(dao.findById(id));
    }

    @Override
    @Transactional
    public ResponseView update(UpdateRequestDto requestDto) {
        OrganizationResponseDto currentOrg = (OrganizationResponseDto) findById(requestDto.getId());
        if (requestDto.getPhone() == null) {
            requestDto.setPhone(currentOrg.getPhone());
        }
        dao.update(factory.convert(requestDto));
        return new ResponseView("success");
    }

    @Override
    @Transactional
    public ResponseView save(Dto organization) {
        dao.save(factory.convert((SaveRequestDto) organization));
        return new ResponseView("success");
    }

    @Override
    public List<Dto> getAll(FilterRequestDto filterRequest) {
        return factory.getOrgsListDto(dao.getAll(filterRequest));
    }
}
