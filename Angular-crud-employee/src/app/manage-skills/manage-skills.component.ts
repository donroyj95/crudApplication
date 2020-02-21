import { Component, OnInit } from '@angular/core';
import {ApiService} from "../Service/api.service";
import {Skill} from "../model/skill";
import {Router} from "@angular/router";

@Component({
  selector: 'app-manage-skills',
  templateUrl: './manage-skills.component.html',
  styleUrls: ['./manage-skills.component.css']
})
export class ManageSkillsComponent implements OnInit {

  skills:Skill[]=[];
  model:Skill=new Skill();
  skillName: string[] = [];
  tempSkill:Skill=new Skill();

  constructor(private  apiService:ApiService,private router: Router) { }

  ngOnInit() {
    this.getAllSkills();
  }
 // editField: string;







  //UPDATE SKILL
  updateList(id: number, property: number, event: any) {
    const editField = event.target.textContent;

    if(this.skillName.indexOf(editField)>=0|| editField==""){
      alert("Invalid Entry");
      location.reload();
    }else {
      this.tempSkill.skill = editField;

      //alert(this.tempSkill.skill);
      this.apiService.updateSkill(this.tempSkill, id).subscribe(
        res=>{
          location.reload();
        },
        err=>{
          alert("Error in Update Skill");
        }
      );
    }
  }








  //REMOVE SKILL
  remove(id:number): void {
    this.apiService.deleteSkill(id).subscribe(
      res=>{
        location.reload();
      },
      err=>{
        alert("This skills is used");
      }
    );
  }









  //CREATING NEW SKILL
  sendAdd():void {

    if(this.skillName.indexOf(this.model.skill.toLowerCase())>=0){
        alert("Duplicate Name");
    }
    else{
      this.model.skill=this.model.skill.toLowerCase();

      this.apiService.postSkill(this.model).subscribe(
        res=>{
          location.reload();
        },
        err=>{
          alert("Error in adding a skill");
        }
      );
    }

  }

  // changeValue(id: number, property: string, event: any) {
  //   //alert(id);
  //   this.editField = event.target.textContent;
  //  //alert(this.editField);
  // }











  //GET ALL SKILLS
  public getAllSkills(){
    this.apiService.getAllSkills().subscribe(
      res=>{
        this.skills=res;
        for(let sk of this.skills){
          this.skillName.push(sk.skill);
        }

      },
      err=>{
        alert("An error in get skills in manage skills");
      }
    );

  }


}











//
// import { Component } from '@angular/core';
//
// @Component({
//   selector: 'table-editable',
//   templateUrl: './table-editable.component.html',
//   styleUrls: ['./table-editable.component.css']
// })
// export class TableEditableComponent {
//
// }
