package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "work_position", nullable = false)
    private String workPosition;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "Person_Document",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    private Set<Document> documents;

    @Column(name = "doc_number")
    private String docNumber;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "Person_Citizenship",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "citizenship_id")
    )
    private Set<Citizenship> citizenships;

    @Column(name = "is_identified")
    private boolean isIdentified;

    @JoinColumn(name = "office_id", nullable = false)
    @ManyToOne(optional =  false, cascade = CascadeType.ALL)
    private Office office;

    public Person(Integer id, String firstName, String secondName, String middleName, String phone, String workPosition, Set<Document> documents, String docNumber, LocalDate docDate, Set<Citizenship> citizenships, boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phone = phone;
        this.workPosition = workPosition;
        this.documents = documents;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenships = citizenships;
        this.isIdentified = isIdentified;
    }
}
