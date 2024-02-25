package kz.kbtu.project.repository;

import kz.kbtu.project.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);
}
