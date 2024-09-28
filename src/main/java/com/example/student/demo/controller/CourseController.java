package com.example.student.demo.controller;

import com.example.student.demo.model.FacultyProfile;
import com.example.student.demo.model.StudentProfile;
import com.example.student.demo.repository.EnrollmentRepository;
import com.example.student.demo.service.CourseService;
import com.example.student.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/faculty")
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {

    @Autowired
    private FacultyService facultyProfileService;

    @PostMapping("/update")
    public ResponseEntity<String> updateFacultyProfile(@RequestBody FacultyProfile facultyProfile) {
        System.out.println(facultyProfile);
        facultyProfileService.updateProfile(facultyProfile);
        return ResponseEntity.ok("Profile updated successfully");
    }

    @GetMapping("/profile/{userId}")
    public FacultyProfile getFacultyProfile(@PathVariable Long userId) {
        return facultyProfileService.getProfileById(userId);
    }
}


