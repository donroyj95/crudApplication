package crud.demo.controller;


import crud.demo.EmployeeDto.EmployeeDto;
import crud.demo.model.Employee;
import crud.demo.service.EmployeeService;
import crud.demo.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;




@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    //private EmployeeRepo employeeDB;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }



    //GET ALL EMPLOYEES CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<Employee> getAll(){
        return employeeService.GetAllEmployee();
    }



    //CREATE AN EMPLOYEE CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public List<Employee> create(@RequestBody EmployeeDto employeeDto) throws Exception {
        System.out.println(employeeDto.getDob());
        return employeeService.CreateEmployee(employeeDto);
    }


    //DELETE AN EMPLOYEE CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public List<Employee> delete(@PathVariable long id){
        return employeeService.DeleteEmployee(id);
    }



    //UPDATE AN EMPLOYEE CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
    public List<Employee> update(@PathVariable long id, @Valid @NonNull @RequestBody EmployeeDto employeeDto) throws Exception {
        return employeeService.UpdateEmployee(employeeDto,id);
    }


    //GET ALL EMPLOYEE_DTO CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/employeeDto/all",method = RequestMethod.GET)
    public List<EmployeeDto> getAllEmp() throws Exception {
        return employeeService.GetAllEmployeeDto();
    }


    //GET AN EMPLOYEE BY ID CONTROLLER
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public EmployeeDto getEmployeeById(@PathVariable long id) throws Exception {
        return employeeService.GetEmpByID(id);
    }

}
