package com.example.student.demo.repository;

import com.example.student.demo.model.Enrollment;
import com.example.student.demo.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("SELECT e.student FROM Enrollment e " +
            "JOIN e.course c " +
            "WHERE c.faculty.id = :facultyId")
    List<StudentProfile> findStudentsByFacultyId(@Param("facultyId") Long facultyId);

    // Aggregation: Number of enrollments per year
    @Query("SELECT s.year, COUNT(e.id) FROM Enrollment e JOIN StudentProfile s ON e.student.id = s.id GROUP BY s.year")
    List<Object[]> getEnrollmentsByYear();

    // Aggregation: Number of enrollments per course
    @Query("SELECT c.title, COUNT(e.id) FROM Enrollment e JOIN Course c ON e.course.id = c.id GROUP BY c.title")
    List<Object[]> getEnrollmentsByCourse();

    // Aggregation: Number of enrollments per department
    @Query("SELECT d.name, COUNT(e.id) FROM Enrollment e JOIN StudentProfile s ON e.student.id = s.id " +
            "JOIN Department d ON s.department.id = d.id GROUP BY d.name")
    List<Object[]> getEnrollmentsByDepartment();
}

