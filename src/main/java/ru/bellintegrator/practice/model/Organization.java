package ru.bellintegrator.practice.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Организация
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    @Setter(AccessLevel.NONE)
    private Integer version;

    /**
     * Сокращенное название организации
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Полное наименование организации, с формой собственности
     */
    @Column(name = "full_name", length = 200, nullable = false)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 20, nullable = false)
    private String inn;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 10, nullable = false)
    private String kpp;

    /**
     * Юридический адрес
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 30)
    private String phone;

    /**
     * Ведет деятельность или нет
     */
    @Column(name = "is_active")
    private Boolean isActive;

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Organization(Integer id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
