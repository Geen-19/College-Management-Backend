package com.example.student.demo.model;
import jakarta.persistence.*;


@Entity
@Table(name = "administratorprofile")
public class AdministratorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // Getters and Setters
}

