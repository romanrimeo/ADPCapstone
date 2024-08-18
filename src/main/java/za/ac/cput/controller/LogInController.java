package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.LogIn;
import za.ac.cput.service.LogInServiceFacade;

@RestController
@RequestMapping("/api/login")
public class LogInController {
    private final LogInServiceFacade logInServiceFacade;

    @Autowired
    public LogInController(LogInServiceFacade logInServiceFacade) {
        this.logInServiceFacade = logInServiceFacade;
    }

    @PostMapping
    public ResponseEntity<LogIn> createLogIn(@RequestBody LogIn logIn) {
        LogIn createdLogIn = logInServiceFacade.createLogIn(logIn);
        return ResponseEntity.ok(createdLogIn);
    }

    @GetMapping("/{email}")
    public ResponseEntity<LogIn> getLogInByEmail(@PathVariable String email) {
        LogIn logIn = logInServiceFacade.getLogInByEmail(email);
        if (logIn != null) {
            return ResponseEntity.ok(logIn);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<LogIn>> getAllLogIns() {
        Iterable<LogIn> logIns = logInServiceFacade.getAllLogIns();
        return ResponseEntity.ok(logIns);
    }

    @PutMapping("/{email}")
    public ResponseEntity<LogIn> updateLogIn(@PathVariable String email, @RequestBody LogIn logInDetails) {
        try {
            LogIn updatedLogIn = logInServiceFacade.updateLogIn(email, logInDetails);
            return ResponseEntity.ok(updatedLogIn);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteLogIn(@PathVariable String email) {
        try {
            logInServiceFacade.deleteLogIn(email);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
