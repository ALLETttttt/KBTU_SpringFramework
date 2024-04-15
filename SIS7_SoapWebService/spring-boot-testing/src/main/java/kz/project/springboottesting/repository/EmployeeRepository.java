package kz.project.springboottesting.repository;

import kz.project.springboottesting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);

}
