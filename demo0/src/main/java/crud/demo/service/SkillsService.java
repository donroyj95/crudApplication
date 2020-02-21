package crud.demo.service;

import crud.demo.EmployeeDto.EmployeeDto;
import crud.demo.model.Employee;
import crud.demo.model.Skill;
import crud.demo.repository.EmployeeRepo;
import crud.demo.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {
    private EmployeeRepo employeeRepo;
    private SkillRepo skillRepo;



    @Autowired
    public SkillsService(EmployeeRepo employeeRepo,SkillRepo skillRepo){
        this.employeeRepo = employeeRepo;
        this.skillRepo=skillRepo;
    }



    //ADD A NEW SKILL TO REPO
    public List<Skill> addSkill(Skill skills){
        skillRepo.save(skills);
        return skillRepo.findAll();
    }


    //GET ALL SKILLS FROM REPO.
    public List<Skill> getSkills(){
        //Skill ski=new Skill();
       //ski.Print(skillRepo.findAll());
        return skillRepo.findAll();
    }


    //UPDATE AN EXISTING SKILL
    public List<Skill>UpdateSkill( Long id,Skill skillNw) throws Exception{
        //System.out.println(id);
        Skill skill = skillRepo.findById(id).orElseThrow(() -> new Exception("non " + id + " not found"));

        skill.setSkill(skillNw.getSkill());
        System.out.println(skill.getSkill());
        skillRepo.save(skill);

        return skillRepo.findAll();
    }



    //DELETE A SKILL
    public List<Skill> DeleteSkill(Long id){
        skillRepo.deleteById(id);
        return skillRepo.findAll();
    }

}
