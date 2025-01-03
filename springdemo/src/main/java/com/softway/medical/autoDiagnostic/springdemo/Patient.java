package com.softway.medical.autoDiagnostic.springdemo;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Patient")
@DynamicInsert
public class Patient {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstname;
    
    private String lastname;

    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String telNumber;

    private Integer healthIndex;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId")
    private List<Pathology> pathologies;
    public Patient() {
    }

    public Patient(Integer id, String firstname, String lastname, LocalDate dateOfBirth, String telNumber, Integer healthIndex, List<Pathology> pathologies) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.healthIndex = healthIndex;
        this.pathologies = pathologies;
    }

    public Patient(Integer id, String firstname, String lastname, LocalDate dateOfBirth, String telNumber, Integer healthIndex) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.healthIndex = healthIndex;
    }

    public Patient(Integer id, String firstname, String lastname, String telNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = LocalDate.now();
        this.telNumber = telNumber;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getHealthIndex() {
        return this.healthIndex;
    }

    public void setHealthIndex(Integer healthIndex) {
        this.healthIndex = healthIndex;
    }

    public List<Pathology> getPathologies() {
        return this.pathologies;
    }

    public void setPathologies(List<Pathology> pathologies) {
        this.pathologies = pathologies;
    }

}


