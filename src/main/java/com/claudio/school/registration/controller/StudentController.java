package com.claudio.school.registration.controller;

import com.claudio.school.registration.service.StudentService;
import com.claudio.school.registration.exception.NotFoundData;
import com.claudio.school.registration.model.Course;
import com.claudio.school.registration.model.Student;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Mono<Student> create(@RequestBody Student student) {
        return Mono.just(this.studentService.save(student));
    }

    @PutMapping
    public Mono<Student> update( @RequestBody Student student) throws NotFoundData {
        return Mono.just(this.studentService.update(student.getId(), student));
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable("id") Long id){
        return Mono.just(this.studentService.delete(id));
    }

    @GetMapping("/{id}")
    public Mono<Student> find(@PathVariable("id") Long id) throws NotFoundData {
        return Mono.just(this.studentService.get(id));
    }

}
