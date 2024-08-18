package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Employee {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private LogIn logIn;

    @Id
    private String employeeID;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "bookingID")
    private Set<Booking> bookings;

    private Employee(Builder builder){
        this.employeeID = builder.employeeID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.bookings = builder.bookings;
    }

    protected Employee() {}

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getEmployeeID(), employee.getEmployeeID()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getBookings(), employee.getBookings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeID(), getFirstName(), getLastName(), getEmail(), getBookings());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", bookings=" + bookings +
                '}';
    }

    public Set<Booking> getBookings() {
        return bookings;
    }
    public static class Builder{
        private String employeeID;
        private String firstName;
        private String lastName;
        private String email;
        private Set<Booking> bookings;

        public Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setBookings(Set<Booking> bookings) {
            this.bookings = bookings;
            return this;
        }
        public Builder copy(Employee employee){
            this.employeeID = employee.employeeID;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.email = employee.email;
            this.bookings = employee.bookings;
            return this;
        }
        public Employee build(){return new Employee(this);}
    }
}
