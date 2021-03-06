package ru.bellintegrator.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Citizenship {
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
    @JsonIgnore
    private Integer version;

    /**
     * Страна
     */
    @Column(name = "country", length = 25, nullable = false)
    private String name;

    /**
     * Код страны
     */
    @Column(name = "code", length = 25, nullable = false)
    private String code;
}
