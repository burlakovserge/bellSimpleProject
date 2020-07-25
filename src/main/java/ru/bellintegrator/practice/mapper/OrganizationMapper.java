package ru.bellintegrator.practice.mapper;

import org.springframework.stereotype.Component;
import ru.bellintegrator.practice.dto.Dto;
import ru.bellintegrator.practice.dto.organization.request.SaveRequestDto;
import ru.bellintegrator.practice.dto.organization.request.UpdateRequestDto;
import ru.bellintegrator.practice.dto.organization.response.OrganizationResponseDto;
import ru.bellintegrator.practice.model.Organization;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Конвертация из entity в dto и обратно
 */
@Component
public class OrganizationMapper {

    /**
     * Конвертация из entity Organization в dto
     *
     * @param obj - организация
     * @return возвращает dto организации для ответа клиенту
     */
    public static OrganizationResponseDto convert(Organization obj) {
        return OrganizationResponseDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .fullName(obj.getFullName())
                .inn(obj.getInn())
                .kpp(obj.getKpp())
                .address(obj.getAddress())
                .phone(obj.getPhone())
                .isActive(obj.getIsActive())
                .build();
    }

    /**
     * Конвертация данных из запроса на обновление в Organization entity
     *
     * @param obj - дто организации
     * @return возвращает организацию
     */
    public static Organization convert(UpdateRequestDto obj) {
        return new Organization(
                obj.getId(),
                obj.getName(),
                obj.getFullName(),
                obj.getInn(),
                obj.getKpp(),
                obj.getAddress(),
                obj.getPhone(),
                obj.getIsActive());
    }

    /**
     * Конвертация данных из запроса на создане новой записи в Organization entity
     *
     * @param obj - дто организации
     * @return возвращает организацию
     */
    public Organization convert(SaveRequestDto obj) {
        return new Organization(
                obj.getName(),
                obj.getFullName(),
                obj.getInn(),
                obj.getKpp(),
                obj.getAddress(),
                obj.getPhone(),
                obj.getIsActive());
    }

    /**
     * Конвертация из списка entity Organization в список dto
     *
     * @param org - список организаций
     * @return возвращает список дто организаций
     */
    public List<Dto> getOrgsListDto(List<Organization> org) {
        return org.stream().map(OrganizationMapper::convert).collect(Collectors.toList());
    }
}
