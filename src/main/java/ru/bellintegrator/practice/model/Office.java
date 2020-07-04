package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

    @JoinColumn(name = "org_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Organization organization;

    @OneToMany(mappedBy = "office", fetch = FetchType.EAGER)
    private List<Person> persons;
}
