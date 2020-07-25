package ru.bellintegrator.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.dto.organization.request.SaveRequestDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
import ru.bellintegrator.practice.mapper.OrganizationMapper;
import ru.bellintegrator.practice.service.OrganizationService;
import ru.bellintegrator.practice.utils.ResponseVoidMethod;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    OrganizationDao dao;
    OrganizationMapper mapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, OrganizationMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional (isolation=Isolation.READ_COMMITTED)
    public Dto findById(Integer id) {
        return OrganizationMapper.convert(dao.findById(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional (isolation=Isolation.READ_COMMITTED)
    public void update(UpdateRequestDto requestDto) {
        OrganizationResponseDto currentOrg = (OrganizationResponseDto) findById(requestDto.getId());
        if (requestDto.getPhone() == null) {
            requestDto.setPhone(currentOrg.getPhone());
        }
        dao.update(mapper.convert(requestDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional (isolation= Isolation.READ_COMMITTED)
    public void add(Dto organization) {
        dao.add(mapper.convert((SaveRequestDto) organization));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Dto> getAll(FilterRequestDto filterRequest) {
        return mapper.getOrgsListDto(dao.getAll(filterRequest));
    }
}
