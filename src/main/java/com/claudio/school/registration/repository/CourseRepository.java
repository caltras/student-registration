package com.claudio.school.registration.repository;

import com.claudio.school.registration.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
