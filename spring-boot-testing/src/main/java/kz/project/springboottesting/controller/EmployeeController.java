package kz.project.springboottesting.controller;

import kz.project.springboottesting.dto.EmployeeDto;
import kz.project.springboottesting.entity.Employee;
import kz.project.springboottesting.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeServiceImpl.getEmployeeById(id);
    }

    @GetMapping("/employees/byName{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeServiceImpl.findEmployeeByName(name);
    }

    @PostMapping("/employees")
    public String createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employeeServiceImpl.createEmployee(employee);
        return "Instance is created";
    }
}