import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Skill} from "../model/skill";
import {EmployeeDto} from "../model/employee-dto";
//import {Employee} from "../model/employee";


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL="http://localhost:8080/";
  private CREATE_EMPLOYEE_URL=`${this.BASE_URL}\\employee\\create`;
  private ALL_SKILLS_URL=`${this.BASE_URL}\\skills\\all`;
  private All_EMP_GET_URL=`${this.BASE_URL}\\employee\\employeeDto\\all`;
  private DELETE_EMP_URL=`${this.BASE_URL}\\employee\\delete\\`;
  private GET_EMP_BYID_URL=`${this.BASE_URL}\\employee\\`;
  private UPDATE_EMP_BYID_URL=`${this.BASE_URL}\\employee\\update\\`;
  private CREATE_SKILL_URL=`${this.BASE_URL}\\skills\\create\\`;
  private UPDATE_SKILL_URL=`${this.BASE_URL}\\skills\\update\\`;
  private DELETE_SKILL_URL=`${this.BASE_URL}\\skills\\delete\\`;

  constructor(private http:HttpClient ) {

  }
  getAllSkills():Observable<Skill[]>{
    return this.http.get<Skill[]>(this.ALL_SKILLS_URL);

  }

  postEmployee(employeeDto: EmployeeDto):Observable<any>{
    // employeeDto.skillId=skillsArr;
     //alert(employeeDto.skillId);
    return this.http.post(this.CREATE_EMPLOYEE_URL,employeeDto);
  }

  postSkill(skill:Skill):Observable<any>{
    return this.http.post(this.CREATE_SKILL_URL,skill);
  }

   getAllEmployee():Observable<EmployeeDto[]>{
    return this.http.get<EmployeeDto[]>(this.All_EMP_GET_URL);
   }

   deleteEmployee(employeeId:number):Observable<any>{
    return this.http.delete(this.DELETE_EMP_URL+employeeId);
   }

   deleteSkill(skillId:number):Observable<any>{
    return this.http.delete(this.DELETE_SKILL_URL+skillId);
   }

  getEmployeeById(employeeId:number):Observable<any>{
    return this.http.get(this.GET_EMP_BYID_URL+employeeId);
  }
  updateEmployee(employeeDto: EmployeeDto,employeeId:number):Observable<any>{
    return this.http.put(this.UPDATE_EMP_BYID_URL+employeeId,employeeDto);
  }
  updateSkill(skill: Skill,skillId:number):Observable<any>{
    return this.http.put(this.UPDATE_SKILL_URL+skillId,skill);
  }



}
