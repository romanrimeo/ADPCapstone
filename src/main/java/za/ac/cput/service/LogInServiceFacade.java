package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Util.Helper;
import za.ac.cput.domain.LogIn;
import za.ac.cput.repository.LoginRepository;

@Service
public class LogInServiceFacade {
    private final LoginRepository loginRepository;

    @Autowired
    public LogInServiceFacade(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LogIn createLogIn(LogIn logIn) {
        if (Helper.isValidEmail(logIn.getEmail()) && Helper.validPassword(logIn.getPassword())) {
            return loginRepository.save(logIn);
        } else {
            throw new IllegalArgumentException("Invalid LogIn Data");
        }
    }

    public LogIn getLogInByEmail(String email) {
        return loginRepository.findById(email).orElse(null);
    }

    public Iterable<LogIn> getAllLogIns() {
        return loginRepository.findAll();
    }

    public LogIn updateLogIn(String email, LogIn logInDetails) {
        LogIn existingLogIn = loginRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("LogIn Not Found"));

        LogIn updatedLogIn = new LogIn.Builder()
                .setEmail(existingLogIn.getEmail())
                .setPassword(logInDetails.getPassword() != null ? logInDetails.getPassword() : existingLogIn.getPassword())
                .build();

        if (Helper.isValidEmail(updatedLogIn.getEmail()) && Helper.validPassword(updatedLogIn.getPassword())) {
            return loginRepository.save(updatedLogIn);
        } else {
            throw new IllegalArgumentException("Invalid Password");
        }
    }

    public void deleteLogIn(String email) {
        LogIn logIn = loginRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("LogIn Not Found"));
        loginRepository.delete(logIn);
    }

}
