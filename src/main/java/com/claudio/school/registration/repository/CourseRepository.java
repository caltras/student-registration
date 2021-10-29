package com.claudio.school.registration.repository;

import java.util.List;

import com.claudio.school.registration.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long>{


    @Query(
        value = "SELECT * FROM course c WHERE NOT EXISTS (SELECT * from registration r WHERE c.id = r.course_id)", 
        nativeQuery = true
    )
    List<Course> findAllEmptyCourses();
    
}
