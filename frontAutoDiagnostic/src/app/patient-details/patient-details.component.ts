import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-patient-details',
  standalone: false,
  
  templateUrl: './patient-details.component.html',
  styleUrl: './patient-details.component.css'
})
export class PatientDetailsComponent implements OnInit{
  
  id!: number;
  patient!: Patient;

  constructor(private route: ActivatedRoute, private patientService: PatientService){

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; 
    console.log("the id of selected patient is = " + this.id);
    this.patient = new Patient();
    this.patientService.getPatientById(this.id).subscribe(data => {
      this.patient = data;
    });
  }

}
