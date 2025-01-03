package com.softway.medical.autoDiagnostic.springdemo;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class DBPatientService implements PatientService {

    private final PatientRepository patientRepository;

    private PathlogyLoader pathologyService;

    public DBPatientService(PatientRepository repository, PathlogyLoader pathologyService) {
        this.patientRepository = repository;
        this.pathologyService = pathologyService;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);    
    }
    @Override
    public List<Patient> savePatients(List<Patient> patients) {
        return patientRepository.saveAll(patients);
    }

    @Override
    public List<Patient> findAllPatients() {
        return (List<Patient>)patientRepository.findAll();
    }

    @Override
    public Patient findById(Integer id) {
        if(patientRepository.findById(id).isPresent()) {
            Patient p = patientRepository.findById(id).get();
            if(p.getHealthIndex() == null) {
                p.setHealthIndex(new Random().nextInt(100));
                p.setPathologies(pathologyService.getPathology(p.getHealthIndex()));

                return patientRepository.save(p);
            }
        } return patientRepository.findById(id).orElse(null);
    } 

    @Override
    public Patient updatePatient(Integer id, Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty())
            return patientRepository.save(patient);
        else {
            Patient p = patientRepository.findById(id).get();
            p.setFirstname(patient.getFirstname());
            p.setLastname(patient.getLastname());
            p.setDateOfBirth(patient.getDateOfBirth());
            p.setTelNumber(patient.getTelNumber());
            p.setHealthIndex(patient.getHealthIndex());
            return patientRepository.save(p);
        }

    }

    @Override
    public Optional<Patient> findByTelNumber(String telNumber) {
        return patientRepository.findByTelNumber(telNumber);
    }

    @Override
    public Optional<Patient> findByFirstname(String firstname) {
        return patientRepository.findByFirstname(firstname);

    }

    @Override
    public Optional<Patient> findByLastname(String lastname) {
        return patientRepository.findByLastname(lastname);
    }


}
