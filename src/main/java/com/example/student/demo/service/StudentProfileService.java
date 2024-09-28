package com.example.student.demo.service;

import com.example.student.demo.model.StudentProfile;
import com.example.student.demo.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileService {
    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public StudentProfile getStudentProfile(Long id) {
        return studentProfileRepository.findById(id).orElse(null);
    }

    public List<StudentProfile> searchStudents(String name, String department, String year) {
        List<StudentProfile> ls = studentProfileRepository.searchStudents(name, department, year);
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i).toString());
        }
        return ls;
    }
}
