package com.softway.medical.autoDiagnostic.springdemo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Optional<Patient> findByTelNumber(String telNumber);

    Optional<Patient> findByFirstname(String firstname);

    Optional<Patient> findByLastname(String lastname);
    
}
