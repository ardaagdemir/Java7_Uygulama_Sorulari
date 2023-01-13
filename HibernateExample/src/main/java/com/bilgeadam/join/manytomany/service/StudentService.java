package com.bilgeadam.join.manytomany.service;

import com.bilgeadam.join.manytomany.entity.Course;
import com.bilgeadam.join.manytomany.entity.Student;
import com.bilgeadam.join.manytomany.repository.StudentDao;

import java.util.Arrays;

public class StudentService {

    public static void main(String[] args) {
        save();
    }

    static StudentDao studentDao = new StudentDao();

    public static void save(){
        Course course1 = new Course("Perfect English");
        Student student1 = new Student("Ali", "Bilir", "Erkek", Arrays.asList(course1));

        studentDao.save(student1);
    }
}
