package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Util.Helper;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;

@Service
public abstract class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee createEmployee(Employee employee){
        if (Helper.isValidEmployee(employee)){
            return employeeRepository.save(employee);
        }
        else {
            throw new IllegalArgumentException("Employee not found");
        }
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getEmployeeById(String id) {
        return employeeRepository.findByEmployeeID(id);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(String EmployeeID, Employee employeeDetails) {
        Employee ExistingEmployee = employeeRepository.findById(EmployeeID)
                .orElseThrow(() -> new IllegalArgumentException
                        ("Employee not found"));

        Employee updatedEmployee = new Employee.Builder()
                .setEmployeeID(ExistingEmployee.getEmployeeID())
                .setFirstName(employeeDetails.getFirstName() != null ? employeeDetails.getFirstName() : ExistingEmployee.getFirstName())
                .setLastName(employeeDetails.getLastName() != null ? employeeDetails.getLastName() : ExistingEmployee.getLastName())
                .setEmail(employeeDetails.getEmail() != null ? employeeDetails.getEmail() : ExistingEmployee.getEmail())
                .build();

        if (Helper.isValidEmployee(updatedEmployee)) {
            return employeeRepository.save(updatedEmployee);
        } else {throw new IllegalArgumentException("Employee Data Invalid");}
    }
    public void deleteEmployee(String employeeID){
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        employeeRepository.delete(employee);
    }
}
