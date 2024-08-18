package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class LogIn {

    @Id
    private String email;
    private String password;

    protected LogIn(){}

    @OneToOne(mappedBy = "logIn", cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private Employee employee;
    private LogIn(Builder builder){
        this.email = builder.email;
        this.password = builder.password;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogIn logIn)) return false;
        return Objects.equals(getEmail(), logIn.getEmail()) && Objects.equals(getPassword(), logIn.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword());
    }

    @Override
    public String toString() {
        return "LogIn{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static class Builder{
        private String email;
        private String password;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder copy(LogIn login){
            this.email = login.email;;
            this.password = login.password;
            return this;
        }
        public LogIn build(){return new LogIn(this);}
    }
}
