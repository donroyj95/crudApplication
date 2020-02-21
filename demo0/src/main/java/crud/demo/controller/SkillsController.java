package crud.demo.controller;
import crud.demo.model.Employee;
import crud.demo.model.Skill;
import crud.demo.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/skills")
public class SkillsController {



    @Autowired
    private SkillsService skillsService;


    //CREATE A SKILL CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/create", method = RequestMethod.POST)
    public List<Skill> create(@RequestBody Skill skills){
        return skillsService.addSkill(skills);
    }




    //GET ALL SKILL CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Skill> getAll(){
        return skillsService.getSkills();
    }




    //UPDATE A SKILL
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public List<Skill> update(@PathVariable Long id,@RequestBody Skill skill) throws Exception {
        return skillsService.UpdateSkill(id,skill);
    }




    //DELETE A SKILL
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public List<Skill> delete(@PathVariable long id){
        return skillsService.DeleteSkill(id);
    }


}