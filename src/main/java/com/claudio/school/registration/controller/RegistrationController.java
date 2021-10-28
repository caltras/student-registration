package com.claudio.school.registration.controller;

import com.claudio.school.registration.exception.NotFoundData;
import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.model.Student;
import com.claudio.school.registration.service.CourseService;
import com.claudio.school.registration.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private StudentService studentService;
    private CourseService courseService;

    public RegistrationController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/course/{courseId}/student/{studentId}")
    public Mono<String> registerStudentToCourse(@PathVariable("courseId") Long courseId, 
                                    @PathVariable("studentId")  Long studentId) throws NotFoundData {
        Course course = this.courseService.get(courseId);
        Student student = this.studentService.get(studentId);

        if (course.getStudents().size() < course.getMaxStudents()) {
            if (student.getCourses().size() < student.getMaxCourse()){
                course.getStudents().add(student);
                student.getCourses().add(course);
                courseService.save(course);
                studentService.save(student);
                return Mono.just("Student "+ student.getName() + " has enrolled to the course "+ course.getName());
            } else {
                return Mono.just("Student reached the limit of "+ student.getMaxCourse()+" courses");
            }
        } else {
            return Mono.just("Course reached the limit of "+ student.getMaxCourse()+" students.");
        }

    }
    
}
