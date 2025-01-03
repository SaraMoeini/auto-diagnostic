import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient-list',
  standalone: false,
  
  templateUrl: './patient-list.component.html',
  styleUrl: './patient-list.component.css'
})
export class PatientListComponent {

  patients!: Patient[];
  
  constructor( private patientService: PatientService, private router: Router) {}

  ngOnInit(): void {
    this.getPatients();
    const date = new Date(2021, 11, 17);
    //this.patients =[{"id":1,"firstname":"ll","lastname":"kk","dateOfBirth":date,"telNumber":"8989", "healthIndex":9 }];
  }

  private getPatients() {
    this.patientService.getPatientsList().subscribe(data => {
      this.patients = data;
    });
  }
  
  patientDetails(id: number) {
    this.router.navigate([`patient-details`, id]);
  }
}