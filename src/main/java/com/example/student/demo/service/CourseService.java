package com.example.student.demo.service;

import com.example.student.demo.model.Course;
import com.example.student.demo.model.FacultyProfile;
import com.example.student.demo.model.StudentProfile;
import com.example.student.demo.repository.CourseRepository;
import com.example.student.demo.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<StudentProfile> getAllStudentsEnrolledByFacultyId(Long facultyId) {
        // Fetch all students enrolled in courses taught by the specified faculty member
        return enrollmentRepository.findStudentsByFacultyId(facultyId);
    }
}


