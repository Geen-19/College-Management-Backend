package com.example.student.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
public
class LoginRequest {
    private String username;
    private String password;
    private String role;

    // Getters and Setters

}
