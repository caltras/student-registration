package com.claudio.school.registration.model;

import java.sql.Date;
import java.time.Instant;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    @Column
    private Date createdAt = new Date(Instant.now().toEpochMilli());
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Student> students;

    @Column
    @ReadOnlyProperty
    private int maxStudents = 50;
}
