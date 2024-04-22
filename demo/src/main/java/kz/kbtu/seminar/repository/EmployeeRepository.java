package kz.kbtu.seminar.repository;

import kz.kbtu.seminar.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
