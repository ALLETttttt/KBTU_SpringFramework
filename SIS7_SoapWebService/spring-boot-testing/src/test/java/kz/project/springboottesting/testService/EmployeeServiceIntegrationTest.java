//package kz.project.springboottesting.testService;
//
//import kz.project.springboottesting.entity.Employee;
//import kz.project.springboottesting.repository.EmployeeRepository;
//import kz.project.springboottesting.service.EmployeeService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EmployeeServiceIntegrationTest {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    // class code ...
//
//    @Bean
//    public EmployeeService employeeService() {
//        return new EmployeeService();
//    }
//
//    @MockBean
//    private EmployeeRepository employeeRepository;
//
//    @Before
//    public void setUp() {
//        Employee alex = new Employee("alex");
//
//        Mockito.when(employeeRepository.findByName(alex.getName()))
//                .thenReturn(alex);
//    }
//
//    @Test
//    public void whenValidName_thenEmployeeShouldBeFound() {
//        String name = "alex";
//        Employee found = employeeService.getEmployeeByName(name);
//
//        assertThat(found.getName())
//                .isEqualTo(name);
//    }
//}
