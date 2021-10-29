package com.claudio.school.registration.controller;

import com.claudio.school.registration.service.CourseService;
import com.claudio.school.registration.exception.NotFoundData;
import com.claudio.school.registration.model.Course;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService couseService;

    public CourseController(CourseService couseService) {
        this.couseService = couseService;
    }

    @PostMapping
    public Mono<Course> create(@RequestBody Course course) {
        return Mono.just(this.couseService.save(course));
    }

    @PutMapping
    public Mono<Course> update(@RequestBody Course course) throws NotFoundData {
        return Mono.just(this.couseService.update(course.getId(), course));
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable("id") Long id){
        return Mono.just(this.couseService.delete(id));
    }

    @GetMapping("/{id}")
    public Mono<Course> find(@PathVariable("id") Long id) throws NotFoundData {
        Course course = this.couseService.get(id);
        return Mono.just(course);
    }


}
