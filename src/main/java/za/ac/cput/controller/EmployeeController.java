package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeServiceFacade;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeServiceFacade employeeServiceFacade;

    @Autowired
    public EmployeeController(EmployeeServiceFacade employeeServiceFacade) {
        this.employeeServiceFacade = employeeServiceFacade;
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeServiceFacade.createEmployee(employee);
    }

    @GetMapping("/getEmployeeByEmail/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Employee employee = employeeServiceFacade.getEmployeeByEmail(email);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeServiceFacade.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable String id) {
        List<Employee> employee = employeeServiceFacade.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String employeeId, @RequestBody Employee employeeDetails) {
        try {
            Employee updatedEmployee = employeeServiceFacade.updateEmployee(employeeId, employeeDetails);
            return ResponseEntity.ok(updatedEmployee);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{EmployeeID}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeId) {
        try {
            employeeServiceFacade.deleteEmployee(employeeId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
