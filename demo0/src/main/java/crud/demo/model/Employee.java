package crud.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long employeeId;
    private String name;
    private String email;
    private String dob;

    @ManyToMany
    @JoinTable(name="EmpSkill",
        joinColumns = @JoinColumn(name="employee_Id"),
            inverseJoinColumns = @JoinColumn(name="skill_Id")
    )

    @JsonIgnore
   private Set<Skill>skill=new HashSet<>();






    public Employee(){}
    Employee(long Employee_id, String name, String dob){

        this.employeeId = Employee_id;
        this.name = name;
        this.dob = dob;
        // this.skills=skill;
    }






    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setSkill(Set<Skill> skills) {
        this.skill = skills;
    }

    public Set<Skill> getSkill() {
        return skill;
    }



}









