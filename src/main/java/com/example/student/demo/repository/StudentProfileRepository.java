package com.example.student.demo.repository;

import com.example.student.demo.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    @Query("SELECT sp FROM StudentProfile sp " +
            "JOIN sp.user u " +
            "JOIN sp.department d " +
            "WHERE (:name IS NULL OR u.name = :name) " +
            "AND (:department IS NULL OR d.name = :department) " +
            "AND (:year IS NULL OR sp.year = :year)")
    List<StudentProfile> searchStudents(@Param("name") String name,
                                        @Param("department") String department,
                                        @Param("year") String year);

}


