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
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String name;

    @Column(name = "full_name", nullable = false)
    private String fullname;

    @Column (nullable = false)
    private String inn;

    @Column (nullable = false)
    private String kpp;

    @Column (nullable = false)
    private String address;

    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

   // private List<Office> offices;
}
