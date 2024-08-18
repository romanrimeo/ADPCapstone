package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl ="http://localhost:8080/api/employees";

    Employee employee = EmployeeFactory.createEmployee("1","Roman","Tsire","r@gmail.com");


    @Test
    void a_createEmployee() {
        String url = baseUrl + "/createEmployee";

        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee,Employee.class);

        assertNotNull(postResponse);
        System.out.println(postResponse.getBody());
        assertNotNull(postResponse.getBody());
    }

    @Test
    void b_getEmployeeByEmail() {
        String url = baseUrl + "/getEmployeeByEmail/" +employee.getEmail();

        ResponseEntity<Employee> employeeResponseEntity = restTemplate.getForEntity(url,Employee.class);

        System.out.println(employeeResponseEntity.getBody());
        assertNotNull(employeeResponseEntity);
    }

    @Test
    void c_getAllEmployees() {
    }

    @Test
    void d_updateEmployee() {
    }

    @Test
    void e_deleteEmployee() {
    }
}