package crud.demo.service;

import crud.demo.EmployeeDto.EmployeeDto;
import crud.demo.model.Employee;
import crud.demo.model.Skill;
import crud.demo.repository.EmployeeRepo;
import crud.demo.repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
import java.util.*;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    private SkillRepo skillRepo;
    Set<Skill>skills;


    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, SkillRepo skillRepo){
        this.employeeRepo = employeeRepo;
        this.skillRepo=skillRepo;
    }


    public List<Employee> GetAllEmployee(){
        return employeeRepo.findAll();
    }


    //DELETE AN EMPLOYEE SERVICE
    public List<Employee>DeleteEmployee(long id){
        employeeRepo.deleteById(id);
        return employeeRepo.findAll();
    }



    //UPDATE AN EMPLOYEE SERVICE
    public List<Employee>UpdateEmployee(EmployeeDto newEmployee, long id)
            throws Exception{
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new Exception("non " + id + " not found"));
        employee.setName(newEmployee.getName());
        employee.setDob(newEmployee.getDob());
        employee.setEmail(newEmployee.getEmail());

        Set<Skill> sk=new HashSet<>();

        for(Long skill:newEmployee.getSkillId()){
            Skill tem;
            tem=skillRepo.findById(skill).orElseThrow(()-> new Exception("non " + " not found"));
            sk.add(tem);
        }

        employee.setSkill(sk);
        employeeRepo.save(employee);
        return employeeRepo.findAll();
    }





    //CREATE AN EMPLOYEE
    public List<Employee>CreateEmployee( EmployeeDto employeeDto) throws Exception {   Employee employee1 = new Employee();

        employee1.setName(employeeDto.getName());
        employee1.setDob(employeeDto.getDob());
        employee1.setEmail(employeeDto.getEmail());
        Set<Skill> sk=new HashSet<>();

        for(Long skill:employeeDto.getSkillId()){
           Skill tem;
                tem=skillRepo.findById(skill).orElseThrow(()-> new Exception("non " + " not found"));
            sk.add(tem);
                System.out.println(tem.getSkill());
        }

        employee1.setSkill(sk);
        employeeRepo.save(employee1);
        return employeeRepo.findAll();

    }





    //GET ALL EMPLOYEES AS EMPLOYEE_DTO
    public List<EmployeeDto> GetAllEmployeeDto(){

        List<EmployeeDto> employeeD=new ArrayList<>();
        for(Employee emp:employeeRepo.findAll()){
            EmployeeDto employeeDto=new EmployeeDto();
            employeeDto.setId(emp.getEmployeeId());
            employeeDto.setName(emp.getName());
            employeeDto.setDob(emp.getDob());
            employeeDto.setEmail(emp.getEmail());
            List<Long> Ar = new ArrayList<>();

            for(Skill sk:emp.getSkill()){
                Ar.add(sk.getSkillId());
            }

            employeeDto.setSkillId(Ar);
            employeeD.add(employeeDto);
        }

        return employeeD;
    }





    //GET AN EMPLOYEE ID USING EMPLOYEE_DTO
    public EmployeeDto GetEmpByID(Long id) throws Exception{
        Employee emp=new Employee();
        EmployeeDto empD=new EmployeeDto();
        emp=employeeRepo.findById(id).orElseThrow(()-> new Exception("non " + " not found"));;
        empD.setId(emp.getEmployeeId());
        empD.setName(emp.getName());
        empD.setDob(emp.getDob());
        empD.setEmail(emp.getEmail());

        List<Long> Ar = new ArrayList<>();
        for(Skill sk:emp.getSkill()){
            Ar.add(sk.getSkillId());
        }
        empD.setSkillId(Ar);
        return empD;

    }













}
