package ru.bellintegrator.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.Mapper.OrganizationMapper;
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

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    OrganizationDao dao;
    OrganizationMapper factory;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, OrganizationMapper factory) {
        this.dao = dao;
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dto findById(Integer id) {
        return OrganizationMapper.convert(dao.findById(id));
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResponseView add(Dto organization) {
        dao.add(factory.convert((SaveRequestDto) organization));
        return new ResponseView("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Dto> getAll(FilterRequestDto filterRequest) {
        return factory.getOrgsListDto(dao.getAll(filterRequest));
    }
}
