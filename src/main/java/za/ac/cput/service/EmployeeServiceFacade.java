package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Util.Helper;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceFacade {
    private static EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceFacade(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getEmployeeById(String id) {
        return employeeRepository.findByEmployeeID(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee updateEmployee(String employeeID, Employee employeeDetails) {
        Employee existingEmployee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        Employee updatedEmployee = new Employee.Builder()
                .setEmployeeID(existingEmployee.getEmployeeID())
                .setFirstName(employeeDetails.getFirstName() != null ? employeeDetails.getFirstName() : existingEmployee.getFirstName())
                .setLastName(employeeDetails.getLastName() != null ? employeeDetails.getLastName() : existingEmployee.getLastName())
                .setEmail(employeeDetails.getEmail() != null ? employeeDetails.getEmail() : existingEmployee.getEmail())
                .build();

        if (Helper.isValidEmployee(updatedEmployee)) {
            return employeeRepository.save(updatedEmployee);
        } else {
            throw new IllegalArgumentException("Employee Data Invalid");
        }
    }

    public void deleteEmployee(String employeeID) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        employeeRepository.delete(employee);
    }

}
