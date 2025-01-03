import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientListComponent } from './patient-list/patient-list.component';
import { SavePatientComponent } from './save-patient/save-patient.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';

const routes: Routes = [
  {path: 'patients', component: PatientListComponent},
  {path: 'save-patient', component: SavePatientComponent},
  {path: '', redirectTo: 'patients', pathMatch: 'full'},
  {path:'patient-details/:id', component: PatientDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
