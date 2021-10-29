package com.claudio.school.registration.service;

import java.util.List;

import com.claudio.school.registration.model.Student;
import com.claudio.school.registration.repository.StudentRepository;

import org.springframework.stereotype.Service;

@Service
public class StudentService extends GenericService<Student, StudentRepository> {

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> studentsNotEnrolled(){
        return this.repository.findAllStudentsNoRegistered();
    }
  
}
