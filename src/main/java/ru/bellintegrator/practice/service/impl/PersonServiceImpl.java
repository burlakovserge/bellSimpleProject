package ru.bellintegrator.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Factory.PersonFactory;
import ru.bellintegrator.practice.dao.person.PersonDao;
import ru.bellintegrator.practice.dto.PersonDto;
import ru.bellintegrator.practice.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    PersonDao personDao;
    PersonFactory personFactory;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, PersonFactory personFactory) {
        this.personDao = personDao;
        this.personFactory = personFactory;
    }

    @Transactional
    @Override
    public void add(PersonDto p) {
       // Person result = new Person(p.getId(), p.getFirstName(), p.getWorkPosition());
      //  personDao.save(result);
    }

    @Override
    public PersonDto findById(Integer id) {
        return personFactory.convertToDto(personDao.loadById(id));
    }

}
