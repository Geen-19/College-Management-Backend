package com.example.student.demo.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String grade;

    // Getters and Setters
}

