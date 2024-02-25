package kz.kbtu.project.controller;

import kz.kbtu.project.model.Employee;
import kz.kbtu.project.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public Iterable<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @GetMapping("/filter")
    public Page<Employee> filterBooks(@ParameterObject Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @PostMapping("/employees")
    public Employee addOneEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }
}