package com.riwi._06_Api_Salon_Belleza.domain.entities;

import java.util.List;

import com.riwi._06_Api_Salon_Belleza.utils.enums.RoleEmployee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String firstName;
    @Column(length = 100, nullable = false)
    private String lastName;
    @Column(length = 100)
    private String email;
    @Column(length = 20)
    private String phone;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEmployee role;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        mappedBy = "employee",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<Appointment> appointments;
}
