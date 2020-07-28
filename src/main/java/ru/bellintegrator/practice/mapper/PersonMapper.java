package ru.bellintegrator.practice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dao.citizenship.CitizenshipDao;
import ru.bellintegrator.practice.dao.office.OfficeDao;
import ru.bellintegrator.practice.dao.сatalogue.CatalogueDocInfoDao;
import ru.bellintegrator.practice.dto.person.request.SaveRequestPersonDto;
import ru.bellintegrator.practice.dto.person.response.ResponsePersonDtoMappingId;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.Person;

@Component
public class PersonMapper {

    CitizenshipDao citizenshipDao;
    OfficeDao officeDao;

    @Autowired
    public PersonMapper(CitizenshipDao citizenshipDao, OfficeDao officeDao) {
        this.citizenshipDao = citizenshipDao;
        this.officeDao = officeDao;
    }

    public ResponsePersonDtoMappingId convert(Person p) {
        return new ResponsePersonDtoMappingId(
                p.getId(), p.getFirstName(), p.getSecondName(), p.getMiddleName(), p.getPosition(), p.getPhone(),
                p.getDocument().getCatalogueDocInfo().getName(), p.getDocument().getNumber(), p.getDocument().getDate(),
                p.getCitizenship().getName(), p.getCitizenship().getCode(), p.getIsIdentified());
    }

    public Person convert(SaveRequestPersonDto dto, Document document) {
        return new Person(0, dto.getFirstName(), dto.getSecondName(), dto.getMiddleName(), dto.getPhone(),
                dto.getPosition(),
                dto.getCitizenshipCode() != null ? citizenshipDao.findByCode(dto.getCitizenshipCode()) : null,
                document, officeDao.findById(dto.getOfficeId()), dto.getIsIdentified());
    }
}
