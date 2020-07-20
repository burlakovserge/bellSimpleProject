package ru.bellintegrator.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "full_name")
    private String fullname;

    private String inn;

    private String kpp;

    private String address;

    private String phone;

    @Column(name = "is_active")
    private boolean active;

    public Organization(String name, String fullname, String inn, String kpp, String address, String phone, boolean active) {
        this.name = name;
        this.fullname = fullname;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.active = active;
    }
}
