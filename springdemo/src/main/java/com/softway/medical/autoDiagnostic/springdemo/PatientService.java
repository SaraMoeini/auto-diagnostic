package com.softway.medical.autoDiagnostic.springdemo;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> savePatients(List<Patient> patient);

    List<Patient> findAllPatients();
    Patient findById(Integer id) throws Exception;
    
    Optional<Patient> findByTelNumber(String telNumber);
    Optional<Patient> findByFirstname(String firstname);
    Optional<Patient> findByLastname(String lastname);

    Patient updatePatient(Integer id, Patient patient);
    
}
