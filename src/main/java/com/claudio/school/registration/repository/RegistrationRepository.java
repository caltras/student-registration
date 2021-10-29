package com.claudio.school.registration.repository;

import java.util.List;

import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.model.Registration;
import com.claudio.school.registration.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

    List<Registration> findByCourse(Course course);

    List<Registration> findByStudent(Student student);
    
}
