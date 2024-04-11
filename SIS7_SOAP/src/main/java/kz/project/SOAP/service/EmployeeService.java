package kz.project.SOAP.service;

import kz.project.SOAP.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
