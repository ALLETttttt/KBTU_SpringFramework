package kz.kbtu.project.repository;

import kz.kbtu.project.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
