import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';

import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ViewEmployeeComponent } from './view-employee/view-employee.component';
import { ManageSkillsComponent } from './manage-skills/manage-skills.component';
import {Router, RouterModule, Routes} from "@angular/router";
import { NotFoundComponent } from './not-found/not-found.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {config} from "rxjs";
import {MatSelectModule} from "@angular/material/select";


const appRoutes: Routes=[
  {
    path:'add',
    component: AddEmployeeComponent
  },
  {
    path:'view',
    component:ViewEmployeeComponent
  },
  {
    path:'manageSkill',
    component:ManageSkillsComponent
  },
  {
    path:'',
    component:AddEmployeeComponent,
    pathMatch:'full'
  },
  {
    path:'**',
    component:NotFoundComponent
  }



  ]

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    AddEmployeeComponent,
    ViewEmployeeComponent,
    ManageSkillsComponent,
    NotFoundComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes, {enableTracing: true}),
    ReactiveFormsModule,
    MatSelectModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
