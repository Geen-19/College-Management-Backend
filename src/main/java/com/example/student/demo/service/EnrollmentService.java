package com.example.student.demo.service;

import com.example.student.demo.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Object[]> getEnrollmentsByYear() {
        return enrollmentRepository.getEnrollmentsByYear();
    }

    public List<Object[]> getEnrollmentsByCourse() {
        return enrollmentRepository.getEnrollmentsByCourse();
    }

    public List<Object[]> getEnrollmentsByDepartment() {
        return enrollmentRepository.getEnrollmentsByDepartment();
    }
}
