package com.softway.medical.autoDiagnostic.springdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/patients")
public class Controller {

    private PatientService patientService;
    private PathologyService pathologyService;

    public Controller(PatientService patientService, PathologyService pathologyService) {
        this.patientService = patientService;
        this.pathologyService = pathologyService;
    }

    @GetMapping
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }
 
    @GetMapping("/{id}")
    public Patient findPatientById(@PathVariable Integer id) throws Exception {
        return patientService.findById(id);
    }

    @PostMapping
    public Patient savePatient( @RequestBody Patient patient)  throws Exception {
        if(patientService.findByTelNumber(patient.getTelNumber()).isPresent() )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"A patient allready exists with this Number");
        if( (patientService.findByFirstname(patient.getFirstname()).isPresent()) && (patientService.findByLastname(patient.getLastname()).isPresent()) )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"A patient allready exists with this Name");

        return patientService.savePatient(patient);
    }

    @PostMapping("/saveAll")
    public List<Patient> savePatients (@RequestBody List<Patient> patients) {
        return patientService.savePatients(patients);
    }  

    @PutMapping("/update/{id}")
    public Patient putMethodName(@PathVariable Integer id, @RequestBody Patient patient) {   
        return patientService.updatePatient(id, patient);
    }

    @GetMapping("/pathologies")
    public List<Pathology> getMethodName(@RequestParam Pathology pathology) {
        return pathologyService.findAllPathologies();
    }
    
}
