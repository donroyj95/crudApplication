import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";

import {Skill} from "../model/skill";
import {ApiService} from "../Service/api.service";
import {EmployeeDto} from "../model/employee-dto";
import {stringDistance} from "codelyzer/util/utils";
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";


@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
//@ViewChild('frm', null) frm: NgForm;
  skills:Skill[]=[];
  skillsArr: number[]=[];
  skillTemp: string[] = [];
  mapSkill = new Map();
  frmSubmit:boolean=false;
  btnvisibility: boolean = true;


  model:EmployeeDto=new EmployeeDto();
  emp:EmployeeDto;



  constructor(private  apiService:ApiService,private router: Router) { }

  ngOnInit() {
    this.getAllSkills();
    let empid = localStorage.getItem('editEmpId');

    //USE FOR UPDATE AN EMPLOYEE
    if (+empid > 0) {
      this.btnvisibility = false;
      localStorage.removeItem('editEmpId');
      this.apiService.getEmployeeById(+empid).subscribe(res => {

          this.model=res;

          for(let ski of this.model.skillId){
            this.skillTemp.push(localStorage.getItem(ski.toString()));
            this.skillsArr.push(ski);
          }
          //alert(this.model.dob);
      },
        err=>{
        alert("Error in getting employee");
        })


    }
}






  //GET ALL SKILLS
  public getAllSkills(){
    this.apiService.getAllSkills().subscribe(
      res=>{
        this.skills=res;
        //alert(this.skills[1].skillId);
        localStorage.setItem('skills',JSON.stringify(this.skills));



        for(let sk of this.skills) {
          localStorage.setItem(sk.skillId.toString(),sk.skill.toString());
          //this.mapSkill.set(sk.skillId.toString(),sk.skill);

        }
        //let itm:Skill[] =JSON.parse(localStorage.getItem('skills'));
        //alert(itm[0].skillId);
      },
      err=>{
        alert("An error in get skills");
      }
    );

  }




  //ADDING SKILLS TO AN EMPLOYEE
  public addSkills(temp: string, num: number) {

    if (this.skillTemp.find(x => x == temp) == null) {
      this.skillTemp.push(temp);
      this.skillsArr.push(num);
     // alert(num);
    }
    // console.log()
  }







  //DELETE SKILLS FROM AN EMPLOYEE
  public deleteSkills(skill:string){
    const index:number = this.skillTemp.indexOf(skill);
    if (index > -1) {
      this.skillTemp.splice(index, 1);
      this.skillsArr.splice(index,1);
    }
}







  //UPDATE AN EMPLOYEE
  onUpdate():void{

    this.model.skillId=this.skillsArr;


    this.apiService.updateEmployee(this.model,this.model.id).subscribe(
      res=>{
        //location.reload();
        this.router.navigate(['view']);
      },
      err=>{
        alert("An error occurred in Updating Employee");
      }
    )


  }





  //CREATE NEW EMPLOYEE
  sendAdd():void{
   // alert(this.model.dob);
    this.model.id=0;
    this.model.skillId=this.skillsArr;
    this.apiService.postEmployee(this.model).subscribe(
      res=>{

        location.reload();
        },
      err=>{
        alert("An error in Adding Employee");
      }
    )

  }




}

// export interface EmployeeDto {
//
//
// }

// export class model{
//   name:string;
//   dob:string;
//   email:string;
//   skillId:number[];
//
// }
