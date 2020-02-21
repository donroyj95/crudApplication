package crud.demo.EmployeeDto;

import java.util.Date;
import java.util.List;

public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private String dob;
    private List<Long> skillId;

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public List<Long> getSkillId() {
        return skillId;
    }

    public void setSkillId(List<Long> skillId) {
        this.skillId = skillId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
