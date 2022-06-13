package com.ynz.demo.flywaydemo.entities;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Employees",
        indexes = {@Index(name = "Index_first_lastname", columnList = "firstname, lastname"),
        @Index(name = "Index_last_firstname", columnList = "lastname,firstname")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotBlank
    @Size(min = 1, max = 256)
    private String firstname;
    @NotBlank
    @Size(min = 1, max = 256)
    private String lastname;
    private YearMonth startDate;

    @ManyToMany(mappedBy = "employees")
    private Set<Address> addresses = new HashSet<>();

    @Builder
    public Employee(String firstname, String lastname, YearMonth startDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.startDate = startDate;
    }
}
