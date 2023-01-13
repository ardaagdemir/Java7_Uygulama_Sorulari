package com.bilgeadam.join.manytomany.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    //OneToOne, OneToMany ve ManyToMany içerisinde gördüğümüz bütün özellikler kullanılabilir.
    //ManyToOne' da ise mappedBy özelliği yoktur.
    @ManyToMany
    private List<Student> students;

    public Course(String title) {
        this.title = title;
    }
}
