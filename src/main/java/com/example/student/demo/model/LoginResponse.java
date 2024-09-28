package com.example.student.demo.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String role;

    public LoginResponse(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
