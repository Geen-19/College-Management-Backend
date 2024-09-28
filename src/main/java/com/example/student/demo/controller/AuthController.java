package com.example.student.demo.controller;

import com.example.student.demo.model.LoginRequest;
import com.example.student.demo.model.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Replace this with actual user validation logic
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String role = loginRequest.getRole();

        // Mock data for simplicity (in a real scenario, validate from the database)
        if ("user1".equals(username) && "pass1".equals(password) && "STUDENT".equals(role)) {
            return ResponseEntity.ok(new LoginResponse("STUDENT"));
        } else if ("user2".equals(username) && "pass2".equals(password) && "FACULTY_MEMBER".equals(role)) {
            return ResponseEntity.ok(new LoginResponse("FACULTY_MEMBER"));
        } else if ("admin".equals(username) && "adminpass".equals(password) && "ADMINISTRATOR".equals(role)) {
            return ResponseEntity.ok(new LoginResponse("ADMINISTRATOR"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
