package com.ynz.demo.flywaydemo.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String streetName;
    private String buildingNumber;
    private String postNumber;
    private String city;
    private String country;

    @ManyToMany
    @JoinColumn(name = "employee-address")
    private Set<Employee> employees = new HashSet<>();

    @Builder
    public Address(String streetName, String buildingNumber, String postNumber, String city, String country) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.postNumber = postNumber;
        this.city = city;
        this.country = country;
    }
}
