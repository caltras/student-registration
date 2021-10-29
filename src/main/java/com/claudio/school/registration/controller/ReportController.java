package com.claudio.school.registration.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.claudio.school.registration.exception.NotFoundData;
import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.model.Registration;
import com.claudio.school.registration.model.Student;
import com.claudio.school.registration.service.CourseService;
import com.claudio.school.registration.service.RegistrationService;
import com.claudio.school.registration.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin")
public class ReportController {

    private RegistrationService registrationService;
    private StudentService studentService;
    private CourseService courseService;

    public ReportController(StudentService studentService, CourseService courseService, RegistrationService registrationService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.registrationService = registrationService;
    }

    @GetMapping("/registrations/course/{courseId}")
    public Mono<List<Student>> listStudentsOnCourse(@PathVariable("courseId") Long courseId) throws NotFoundData {

        Course course = this.courseService.get(courseId);
        return Mono.just(this.registrationService
                .findAllByCourse(course).parallelStream()
                    .map( r-> r.getStudent()).collect(Collectors.toList()));

    }

    @GetMapping("/registrations/student/{studentId}")
    public Mono<List<Course>> listCourseForStudent(@PathVariable("studentId") Long studentId) throws NotFoundData {

        Student student = this.studentService.get(studentId);
        return Mono.just(this.registrationService
                .findAllByStudent(student).parallelStream()
                    .map( r-> r.getCourse()).collect(Collectors.toList()));

    }

    @GetMapping("/registrations/empty-courses")
    public Mono<List<Course>> listCourseWithouStudents() throws NotFoundData {

        return Mono.just(this.courseService.emptyCourses());

    }

    @GetMapping("/registrations/no-enrolled-students")
    public Mono<List<Student>> listStudentsWithoutCourse() throws NotFoundData {

        return Mono.just(this.studentService.studentsNotEnrolled());

    }
    
    
}
