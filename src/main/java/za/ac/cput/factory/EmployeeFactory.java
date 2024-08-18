package za.ac.cput.factory;

import za.ac.cput.Util.Helper;
import za.ac.cput.domain.Employee;

public class EmployeeFactory {
    public static Employee createEmployee(String employeeID,
                                          String firstName,
                                          String lastName,
                                          String email) {
        if (Helper.isNullorEmpty(employeeID) ||
                (Helper.isNullorEmpty(firstName)) || (Helper.isNullorEmpty(lastName))||
                (Helper.isNullorEmpty(email)))
            return null;

        if (!Helper.isValidEmail(email))
            return null;

        return new Employee.Builder()
                .setEmployeeID(employeeID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email).build();
    }
}
