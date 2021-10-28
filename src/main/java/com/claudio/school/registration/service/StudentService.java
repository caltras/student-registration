package com.claudio.school.registration.service;

import com.claudio.school.registration.model.Student;
import com.claudio.school.registration.repository.StudentRepository;

import org.springframework.stereotype.Service;

@Service
public class StudentService extends GenericService<Student, StudentRepository> {

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
  
}
