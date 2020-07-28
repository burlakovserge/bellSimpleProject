package ru.bellintegrator.practice.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.document.DocumentDao;
import ru.bellintegrator.practice.dao.person.PersonDao;
import ru.bellintegrator.practice.dao.сatalogue.CatalogueDocInfoDao;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.person.request.FilterRequestPersonDto;
import ru.bellintegrator.practice.dto.person.request.SaveRequestPersonDto;
import ru.bellintegrator.practice.dto.person.request.UpdateRequestPersonDto;
import ru.bellintegrator.practice.dto.person.response.ResponsePersonDtoMappingList;
import ru.bellintegrator.practice.mapper.PersonMapper;
import ru.bellintegrator.practice.model.CatalogueDocInfo;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    PersonMapper personMapper;
    PersonDao personDao;
    CatalogueDocInfoDao catalogueDocInfoDao;
    DocumentDao documentDao;
    ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonMapper personMapper, PersonDao personDao, CatalogueDocInfoDao catalogueDocInfoDao, DocumentDao documentDao, ModelMapper modelMapper) {
        this.personMapper = personMapper;
        this.personDao = personDao;
        this.catalogueDocInfoDao = catalogueDocInfoDao;
        this.documentDao = documentDao;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void add(SaveRequestPersonDto requestOrg) {
        if (requestOrg.getDocCode() != null) {
            CatalogueDocInfo catalogueDocInfo = catalogueDocInfoDao.findByCode(requestOrg.getDocCode());
            Document document = new Document(0, requestOrg.getDocNumber(), requestOrg.getDocDate(), catalogueDocInfo);
            documentDao.addDocument(document);
            Person person = personMapper.convert(requestOrg, document);
            personDao.add(person);
        } else {
            System.out.println("ddd");
            Person person = personMapper.convert(requestOrg, null);
            personDao.add(person);
        }
    }

    @Override
    public Dto findById(Integer id) {
        return personMapper.convert(personDao.findById(id));
    }

    @Override
    public List<ResponsePersonDtoMappingList> getList(FilterRequestPersonDto request) {

        List<Person> list = personDao.getList(request);
        List<ResponsePersonDtoMappingList> respList = modelMapper.map(list,
                new TypeToken<List<ResponsePersonDtoMappingList>>() {
                }.getType());
        return respList;
    }

    @Override
    public void updatePerson(UpdateRequestPersonDto request) {

//        personDao.update(Person person);
    }


}
