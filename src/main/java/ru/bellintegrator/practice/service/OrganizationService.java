package ru.bellintegrator.practice.service;

import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.FilterRequestDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestDto;
import ru.bellintegrator.practice.utils.ResponseView;

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
    ResponseView update(UpdateRequestDto organization);

    /**
     * Добавить новую Organization в БД
     *
     * @param organization организация
     * @return возвращает сообщение клиенту
     */
    ResponseView add(Dto organization);

    /**
     * Получить фильтрованый список Organization
     *
     * @param filterRequest - объект с полями, по которым выполнять фильтрацию
     * @return возвращает список объектов по интерфейсу Dto
     */
    List<Dto> getAll(FilterRequestDto filterRequest);
}
