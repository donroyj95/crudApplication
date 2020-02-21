import { Component, OnInit,Input } from '@angular/core';
import {EmployeeDto} from "../model/employee-dto";
import {ApiService} from "../Service/api.service";
import {Skill} from "../model/skill";
import {map} from "rxjs/operators";
import {waitForMap} from "@angular/router/src/utils/collection";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {

 // employeeD:EmployeeDto=new EmployeeDto();
  employeeDto:EmployeeDto[];
   skills:Skill[]=[];
  mapSkill = new Map();


  constructor(private apiService:ApiService,private router: Router) { }

   ngOnInit() {

     let skill:Skill[]=JSON.parse(localStorage.getItem('skills'));
     this.skills=skill;
   this.getAllEmployee();
  }






  //GET ALL EMPLOYEE
  public getAllEmployee(){
    // alert("man");
    for(let sk of this.skills) {
      this.mapSkill.set(sk.skillId,sk.skill);

    }
    this.apiService.getAllEmployee().subscribe(
      res=>{
        this.employeeDto=res;
        //alert(this.employeeDto[23].skillId[0]);
      },
      error => {
        alert("Error occurred in getting employees");
      }
    )
  }

  // public  getAllSkills(){
  //   this.apiService.getAllSkills().subscribe(
  //     res=>{
  //
  //       this.skills=res;
  //        //alert(this.skills[1].skillId);
  //
  //     },
  //     err=>{
  //       alert("An error in get skills");
  //     }
  //   );
  // }






  //DELETE AN EMPLOYEE
  public deleteEmployee(employeeId: number) {
    this.apiService.deleteEmployee(employeeId).subscribe(
      res => {
        this.router.navigate(['view']);

         location.reload();
      }, err => {
        alert("Operation can not be done");
      }
    );
  }






  //EDIT AN EMPLOYEE
  editEmp(employeeDto: EmployeeDto): void {
    localStorage.removeItem('editEmpId');
    localStorage.setItem('editEmpId', employeeDto.id.toString());
    this.router.navigate(['add']);
  }


}
