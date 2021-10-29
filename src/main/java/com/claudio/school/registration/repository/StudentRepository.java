package com.claudio.school.registration.repository;

import java.util.List;

import com.claudio.school.registration.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query(
        value = "SELECT * FROM student s WHERE NOT EXISTS (SELECT * from registration r WHERE s.id = r.student_id)", 
        nativeQuery = true
    )
    List<Student> findAllStudentsNoRegistered();
    
}
