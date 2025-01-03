package com.softway.medical.autoDiagnostic.springdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Pathology")
public class Pathology {

    @Id
    @GeneratedValue
    private Integer id;

    private String pathology;

    public Pathology() {
    }

    public Pathology(Integer id, String pathology) {
        this.id = id;
        this.pathology = pathology;
    }

    public String getPathology() {
        return this.pathology;
    }

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}