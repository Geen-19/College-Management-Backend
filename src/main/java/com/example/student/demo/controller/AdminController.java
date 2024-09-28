package com.example.student.demo.controller;

import com.example.student.demo.model.FacultyProfile;
import com.example.student.demo.model.StudentProfile;
import com.example.student.demo.service.AdminService;
import com.example.student.demo.service.EnrollmentService;
import com.example.student.demo.service.FacultyService;
import com.example.student.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private FacultyService facultyProfileService;

    @GetMapping("/students")
    public List<StudentProfile> getAllStudents() {
        return adminService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return adminService.getStudentById(id);
    }

    @PostMapping("/students/post")
    public StudentProfile addStudent(@RequestBody StudentProfile studentProfile) {
        return adminService.addStudent(studentProfile);
    }

    @PutMapping("/students/{id}")
    public StudentProfile updateStudent(@PathVariable Long id, @RequestBody StudentProfile studentProfile) {
        return adminService.updateStudent(id, studentProfile);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        adminService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @Autowired
    private AdminService facultyService;

    @GetMapping("/faculty")
    public List<FacultyProfile> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @PostMapping("/faculty/post")
    public FacultyProfile createFaculty(@RequestBody FacultyProfile faculty) {
        return facultyService.saveFaculty(faculty);
    }

    @PutMapping("/faculty/{id}")
    public ResponseEntity<FacultyProfile> updateFaculty(@PathVariable Long id, @RequestBody FacultyProfile facultyDetails) {
        return facultyService.updateFaculty(id, facultyDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/faculty/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }




    // API to get enrollment trends by year
    @GetMapping("/enrollments-by-year")
    public List<Object[]> getEnrollmentsByYear() {
        return enrollmentService.getEnrollmentsByYear();
    }

    // API to get enrollment trends by course
    @GetMapping("/enrollments-by-course")
    public List<Object[]> getEnrollmentsByCourse() {
        return enrollmentService.getEnrollmentsByCourse();
    }

    // API to get enrollment trends by department
    @GetMapping("/enrollments-by-department")
    public List<Object[]> getEnrollmentsByDepartment() {
        return enrollmentService.getEnrollmentsByDepartment();
    }

    // API to get faculty course load (number of courses per faculty)
    @GetMapping("/faculty-course-load")
    public List<Object[]> getFacultyCourseLoad() {
        return facultyProfileService.getCoursesByFaculty();
    }
}