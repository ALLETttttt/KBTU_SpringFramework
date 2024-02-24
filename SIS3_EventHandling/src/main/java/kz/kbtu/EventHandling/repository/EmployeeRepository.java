package kz.kbtu.EventHandling.repository;

import kz.kbtu.EventHandling.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
