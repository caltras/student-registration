package com.claudio.school.registration.model;

import java.sql.Date;
import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.ReadOnlyProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
    
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Registration> registrations;

    @Column
    @ReadOnlyProperty
    private int maxStudents = 50;
    
    public int getNumberOfStudentRegistered() {
        return this.registrations != null ? this.registrations.size() : 0;
    }
}
