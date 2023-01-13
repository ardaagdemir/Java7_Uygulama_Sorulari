package com.bilgeadam.join.manytomany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String gender;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    public Student(String firstName, String lastName, String gender, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.courses = courses;
    }
}
