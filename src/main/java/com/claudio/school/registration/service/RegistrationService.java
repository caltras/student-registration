package com.claudio.school.registration.service;

import java.util.List;

import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.model.Registration;
import com.claudio.school.registration.model.Student;
import com.claudio.school.registration.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService extends GenericService<Registration, RegistrationRepository>{

    public RegistrationService(RegistrationRepository repository) {
        this.repository = repository;
    }

    public List<Registration> findAllByCourse(Course course) {
        return this.repository.findByCourse(course);
    }

    public List<Registration> findAllByStudent(Student student) {
        return this.repository.findByStudent(student);
    }

}
