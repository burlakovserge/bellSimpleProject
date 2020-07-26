package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestOrgDto;
import ru.bellintegrator.practice.dto.organization.response.ResponseOrgDtoMappingList;

import java.util.List;

/**
 * Сервис
 */
public interface OrganizationService {
    /**
     * Найти Organization по id
     *
     * @param id - идентификатор
     * @return возвращает объект интерфейса Dto
     */
    Dto findById(Integer id);

    /**
     * Обновить данные Organization
     *
     * @param organization - организация
     * @return возвращает сообщение клиенту
     */
    void update(UpdateRequestOrgDto organization);

    /**
     * Добавить новую Organization в БД
     *
     * @param organization организация
     * @return возвращает сообщение клиенту
     */
    void add(Dto organization);

    /**
     * Получить фильтрованый список Organization
     *
     * @param filterRequest - объект с полями, по которым выполнять фильтрацию
     * @return возвращает список объектов по интерфейсу Dto
     */
    List<ResponseOrgDtoMappingList> getAll(FilterRequestOrgDto filterRequest);
}
