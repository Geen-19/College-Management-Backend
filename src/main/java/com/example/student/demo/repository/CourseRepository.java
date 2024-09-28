package com.example.student.demo.repository;

import com.example.student.demo.model.Course;
import com.example.student.demo.model.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByFaculty(FacultyProfile faculty);
}


