package com.example.student.demo.controller;

import com.example.student.demo.model.FacultyProfile;
import com.example.student.demo.model.StudentProfile;
import com.example.student.demo.model.User;
import com.example.student.demo.service.CourseService;
import com.example.student.demo.service.FacultyService;
import com.example.student.demo.service.StudentProfileService;
import com.example.student.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentProfileService studentProfileService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/students")
    public List<StudentProfile> searchStudents(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "department", required = false) String department,
                                 @RequestParam(value = "year", required = false) String year,
                                 Model model) {
        return  studentProfileService.searchStudents(name, department, year);
    }



    @GetMapping("/faculty-advisors")
    public List<FacultyProfile> viewFacultyAdvisors() {
        return facultyService.getFacultyAdvisors();
    }
    @Autowired
    private CourseService courseService;

    @GetMapping("/faculty/courseList/{facultyId}")
    public List<StudentProfile> getClassList(@PathVariable Long facultyId) {
        List<StudentProfile> students = courseService.getAllStudentsEnrolledByFacultyId(facultyId);

        return students;
    }


}