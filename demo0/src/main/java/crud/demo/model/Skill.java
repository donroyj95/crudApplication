package crud.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="Skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long skillId;
    private String skill;

    @ManyToMany(mappedBy = "skill")
    @JsonIgnore
    private Set<Employee> employees;
    public Skill(){}
    public Skill(String name,Long id){
        this.skill=name;
        this.skillId=id;

    }
    public long getSkillId() {
        return this.skillId;
    }

    public Skill(String skill){
        this.skill=skill;
    }

    public void addSkill(String skill){
        this.skill=skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {//////
        return skill;
    }

    public void Print(List<Skill>Arr){
        for(Skill ski:Arr){
            System.out.println(ski.getSkillId());
        }
    }

}
