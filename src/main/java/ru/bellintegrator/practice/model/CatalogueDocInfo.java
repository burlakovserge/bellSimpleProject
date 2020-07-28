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
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Catalogue_Docs")
public class CatalogueDocInfo {
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
     * Тип документа
     */
    @Column(name = "name", length = 120, nullable = false)
    private String name;

    /**
     * Код документа
     */
    @Column(name = "code", length = 25, nullable = false)
    private String code;
}