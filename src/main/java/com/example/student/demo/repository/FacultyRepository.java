package com.example.student.demo.repository;


import com.example.student.demo.model.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<FacultyProfile, Long> {
    // You can add custom query methods if needed
}

