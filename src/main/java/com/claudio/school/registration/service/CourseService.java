package com.claudio.school.registration.service;

import java.util.List;

import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.repository.CourseRepository;

import org.springframework.stereotype.Service;

@Service
public class CourseService extends GenericService<Course, CourseRepository>{

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> emptyCourses(){
        return this.repository.findAllEmptyCourses();
    }

}
