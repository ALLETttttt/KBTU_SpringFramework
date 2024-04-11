package kz.project.SOAP.service.impl;

import kz.project.SOAP.model.Employee;
import kz.project.SOAP.repository.EmployeeRepository;
import kz.project.SOAP.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }
}
