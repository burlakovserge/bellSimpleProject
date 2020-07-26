package ru.bellintegrator.practice.dao.organization;

import ru.bellintegrator.practice.dto.organization.request.FilterRequestOrgDto;
import ru.bellintegrator.practice.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Получить Organization по Id
     *
     * @param id - идентификатор
     * @return возвращает объект Organization
     */
    Organization findById (Integer id);

    /**
     * Обновить данные Organization
     *
     * @param organization - организация
     */
    void update(Organization organization);

    /**
     * Добавить новую Organization в БД
     *
     * @param organization - организация
     */
    void add(Organization organization);

    /**
     * Получить фильтрованный список Organization
     *
     * @param filterRequest - объект с полями, по которым выполнять фильтрацию
     * @return возвращает список организаций
     */
    List<Organization> getAll(FilterRequestOrgDto filterRequest);
}
