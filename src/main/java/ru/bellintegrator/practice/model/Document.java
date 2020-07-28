package ru.bellintegrator.practice.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Document {
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
     * Серия, номер документа
     */
    @Column(name = "number", length = 30, nullable = false)
    private String number;

    /**
     * Дата выдачи
     */
    @Column(name = "doc_date", nullable = false)
    private LocalDate date;

    /**
     * ИД в каталоге документов
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "catalogue_docs_id", nullable = false)
    private CatalogueDocInfo catalogueDocInfo;

    public Document(Integer version, String number, LocalDate date, CatalogueDocInfo catalogueDocInfo) {
        this.version = version;
        this.number = number;
        this.date = date;
        this.catalogueDocInfo = catalogueDocInfo;
    }
}