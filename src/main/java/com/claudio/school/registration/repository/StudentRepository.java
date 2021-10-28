package com.claudio.school.registration.repository;

import com.claudio.school.registration.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
