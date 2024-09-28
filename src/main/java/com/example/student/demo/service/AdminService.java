package com.example.student.demo.service;

import com.example.student.demo.model.FacultyProfile;
import com.example.student.demo.model.StudentProfile;
import com.example.student.demo.repository.FacultyRepository;
import com.example.student.demo.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id).orElse(null);
    }

    public StudentProfile addStudent(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    public StudentProfile updateStudent(Long id, StudentProfile studentProfile) {
        studentProfile.setId(id);
        return studentProfileRepository.save(studentProfile);
    }
    @Autowired
    private StudentProfileRepository studentRepository;

    public List<StudentProfile> getAllStudentsAdmin() {
        return studentRepository.findAll();
    }

    public StudentProfile saveStudent(StudentProfile student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Optional<StudentProfile> updateStudentAdmin(Long id, StudentProfile studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setId(studentDetails.getId());
            student.setDepartment(studentDetails.getDepartment());
            student.setYear(studentDetails.getYear());
            return studentRepository.save(student);
        });
    }

    // ADMIN FACULTY

    @Autowired
    private FacultyRepository facultyRepository;

    public List<FacultyProfile> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public FacultyProfile saveFaculty(FacultyProfile faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Optional<FacultyProfile> updateFaculty(Long id, FacultyProfile facultyDetails) {
        return facultyRepository.findById(id).map(faculty -> {
            faculty.setId(facultyDetails.getId());
            faculty.setDepartment(facultyDetails.getDepartment());
            faculty.setOfficeHours(facultyDetails.getOfficeHours());
            return facultyRepository.save(faculty);
        });
    }
}

