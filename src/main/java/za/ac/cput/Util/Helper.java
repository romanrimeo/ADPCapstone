package za.ac.cput.Util;

import za.ac.cput.domain.Employee;

import java.util.regex.Pattern;

public class Helper {

    public static boolean isNullorEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNullorEmpty(long s) {
        Long longValue = s;
        return longValue == null;
    }

    public static boolean isValidCode(String code) {
        if (isNullorEmpty(code))
            return false;
        return code.equalsIgnoreCase("Code8") || code.equalsIgnoreCase("Code10") || code.equalsIgnoreCase("Code14");
    }

    public static boolean isNotTenDigits(String phoneNumber) {
        if (isNullorEmpty(phoneNumber)) {
            return true;
        }
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return phoneNumber.length() != 10;
    }

    public static boolean isValidEmail(String emailAddress) {
        if (isNullorEmpty(emailAddress))
            return false;

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean validPassword(String password) {
        if (isNullorEmpty(password))
            return false;

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!*?&]{8,}$";
        return Pattern.compile(regex)
                .matcher(password)
                .matches();
    }

    public static boolean isValidEmployee(Employee employee) {
        return !isNullorEmpty(employee.getFirstName()) &&
                !isNullorEmpty(employee.getLastName()) &&
                isValidEmail(employee.getEmail());
    }
}
