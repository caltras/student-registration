package com.claudio.school.registration.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date dateOfBirthday;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses;

    @Column
    @ReadOnlyProperty
    private int maxCourse = 5;
    
}
