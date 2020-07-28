package ru.bellintegrator.practice.service.impl;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.response.ResponseOrgDtoMappingId;
import ru.bellintegrator.practice.dto.organization.response.ResponseOrgDtoMappingList;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.service.OrganizationService;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    OrganizationDao dao;
    ModelMapper modelMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Dto findById(Integer id) {
        ResponseOrgDtoMappingId response = modelMapper.map(dao.findById(id), ResponseOrgDtoMappingId.class);
        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(UpdateRequestOrgDto requestDto) {
//        Organization currentOrg = dao.findById(requestDto.getId());
//        if (requestDto.getPhone() == null) {
//            requestDto.setPhone(currentOrg.getPhone());
//        }
//        Organization updatedOrg = modelMapper.map(requestDto, Organization.class);
//        dao.update(updatedOrg);
        Organization currentOrg = dao.findById(requestDto.getId());
        currentOrg.setName(requestDto.getName());
        currentOrg.setFullName(requestDto.getFullName());
        currentOrg.setInn(requestDto.getInn());
        currentOrg.setKpp(requestDto.getKpp());
        currentOrg.setAddress(requestDto.getAddress());
        if (requestDto.getPhone() != null) {
            currentOrg.setPhone(requestDto.getPhone());
        }
        if (requestDto.getIsActive() != null) {
            currentOrg.setIsActive(requestDto.getIsActive());
        }
        dao.update(currentOrg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(Dto requestOrg) {
        Organization organization = modelMapper.map(requestOrg, Organization.class);
        dao.add(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResponseOrgDtoMappingList> getAll(FilterRequestOrgDto filterRequest) {
        List<Organization> orgList = dao.getAll(filterRequest);
        List<ResponseOrgDtoMappingList> respList = modelMapper.map(orgList,
                new TypeToken<List<ResponseOrgDtoMappingList>>() {
                }.getType());
        return respList;
    }
}
