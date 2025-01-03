import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-save-patient',
  standalone: false,
  
  templateUrl: './save-patient.component.html',
  styleUrl: './save-patient.component.css'
})
export class SavePatientComponent implements OnInit{

  patient: Patient = new Patient();

  constructor(private patientService: PatientService, private router: Router) {}

  ngOnInit(): void {  }

  onSubmit() {
    console.log("OnSubmit: \n" +this.patient);
     this.savePatient();
    }
  
    savePatient() {
      this.patientService.createPatient(this.patient).subscribe( data => {
        console.log("savePatient: \n" +data);
        this.goToPatientList();
      }//,
      //error => console.log("Error in save patient ")
      );
    }
    goToPatientList(){
      this.router.navigate(['/patients']);
    }
  }
  