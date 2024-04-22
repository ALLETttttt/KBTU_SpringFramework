package kz.project.springboottesting.service;

import kz.project.springboottesting.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void createEmployee(Employee employee);

    Employee findEmployeeByName(String name);
}
