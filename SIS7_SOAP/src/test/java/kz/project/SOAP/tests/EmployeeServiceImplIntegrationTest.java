package kz.project.SOAP.tests;

import kz.project.SOAP.model.Employee;
import kz.project.SOAP.repository.EmployeeRepository;
import kz.project.SOAP.service.EmployeeService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService() {
                @Override
                public Employee getEmployeeByName(String name) {
                    return null;
                }

                @Override
                public List<Employee> getAllEmployees() {
                    return null;
                }
                // implement methods
            };
        }
    }


    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;


    @Before
    public void setUp() {
        Employee alex = new Employee("alex");

        Mockito.when(employeeRepository.findByName(alex.getName()))
                .thenReturn(alex);
    }
    // class code ...
}

