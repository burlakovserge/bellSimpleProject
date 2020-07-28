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
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
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
     * Имя
     */
    @Column(name = "first_name", length = 50,nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", length = 50)
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50)
    private String middleName;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 30)
    private String phone;

    /**
     * Должность
     */
    @Column(name = "work_position", length = 50, nullable = false)
    private String position;

    /**
     * ИД документа о гражданстве
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "citizenship_id")
    private Citizenship citizenship;

    /**
     * ИД документа удостоверяющего личность
     */
    @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;

    /**
     * ИД оффиса
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    /**
     * Прошел идентификацию или нет
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    public Person(Integer version, String firstName, String secondName, String middleName, String phone, String position, Citizenship citizenship, Document document, Office office, Boolean isIdentified) {
        this.version = version;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.position = position;
        this.citizenship = citizenship;
        this.document = document;
        this.office = office;
        this.isIdentified = isIdentified;
    }


}
