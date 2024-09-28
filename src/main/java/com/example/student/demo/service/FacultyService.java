package com.example.student.demo.service;

import com.example.student.demo.exceptions.ResourceNotFoundException;
import com.example.student.demo.model.FacultyProfile;
import com.example.student.demo.model.User;
import com.example.student.demo.repository.FacultyProfileRepository;
import com.example.student.demo.repository.FacultyRepository;
import com.example.student.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    public List<FacultyProfile> getFacultyAdvisors() {
        // Fetch faculty advisors from the database
        return facultyRepository.findAll();
    }

    @Autowired
    private UserRepository userRepository;

    public void updateProfile(FacultyProfile updatedProfile) {
        // Fetch the existing faculty profile from the database
        FacultyProfile existingProfile = facultyProfileRepository.findById(updatedProfile.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Faculty profile not found with id: " + updatedProfile.getId()));

        // Update fields: officeHours, name, email
        existingProfile.setOfficeHours(updatedProfile.getOfficeHours());
        System.out.println(updatedProfile);
        // Update user details (name, email)
        User user = existingProfile.getUser();
        user.setName(updatedProfile.getUser().getName());
        user.setEmail(updatedProfile.getUser().getEmail());

        // Save the updated profile and user
        userRepository.save(user);
        facultyProfileRepository.save(existingProfile);
    }

    public FacultyProfile getProfileById(Long userId) {
        return facultyProfileRepository.findById(userId).orElse(null); // Return null if not found
    }

    public List<Object[]> getCoursesByFaculty() {
        return facultyProfileRepository.getCoursesByFaculty();
    }
}
