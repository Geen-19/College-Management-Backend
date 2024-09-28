package com.example.student.demo.repository;

import com.example.student.demo.model.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {
    // Aggregation: Number of courses per faculty member
    @Query("SELECT f.user.name, COUNT(c.id) FROM FacultyProfile f JOIN Course c ON f.id = c.faculty.id GROUP BY f.user.name")
    List<Object[]> getCoursesByFaculty();
}
