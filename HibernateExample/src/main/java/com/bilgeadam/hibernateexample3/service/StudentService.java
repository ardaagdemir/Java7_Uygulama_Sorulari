package com.bilgeadam.hibernateexample3.service;

import com.bilgeadam.hibernateexample3.entity.Student;
import com.bilgeadam.hibernateexample3.repository.StudentDao;

import java.util.List;

//NamedQuery, NativeQuery
//Hql(Hibernate Query Language), JPQL(Java Persistence Query Language ), NativeSQL

public class StudentService {

    static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {
        //save();
        //update();
        //delete();
        //deleteById(5);
        //startLike("e");
        //greaterThan(10000);
        //betweenStudentNumbers(1000,10000);
        //nativeSQLQuery1();
        //nativeSQLQuery2();
        //namedQueryFindAllStudents();
        namedQueryFindById(4);
    }

    public static void save(){
        Student student = new Student("Mücahit", "Dogan", "dogan@mail.com", 2846);
        try{
            studentDao.save(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        Student student = new Student(1,"Tunç", "Ergüven", "ergüven@mail.com", 12345);
        try {
            studentDao.update(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(){
        Student student = new Student(6);
        try{
            studentDao.delete(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteById(int id){
        try{
            studentDao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void startLike(String s){
        try {
            studentDao.startLike(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void greaterThan(int number){
        try {
            studentDao.greaterThan(number);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void betweenStudentNumbers(int number1, int number2){
        try{
            studentDao.betweenStudentNumbers(number1, number2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void nativeSQLQuery1(){
        List<Student> list = studentDao.nativeSQLQuery1();
        list.forEach(System.out::println);
    }

    public static void nativeSQLQuery2(){
        studentDao.nativeSQLQuery2();
    }

    public static void namedQueryFindAllStudents(){
        studentDao.namedQueryFindAllStudents();
    }

    public static void namedQueryFindById(int id){
        studentDao.namedQueryFindById(id);
    }


}
