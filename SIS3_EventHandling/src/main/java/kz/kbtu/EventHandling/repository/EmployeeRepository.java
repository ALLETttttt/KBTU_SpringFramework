package kz.kbtu.EventHandling.repository;

import kz.kbtu.EventHandling.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    Optional<Employee> findEmployeeById(Integer id);
}
