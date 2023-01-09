package com.bilgeadam.hibernateexample3.service;

import com.bilgeadam.hibernateexample3.entity.Student;
import com.bilgeadam.hibernateexample3.repository.StudentDao;

//NamedQuery, NativeQuery
//Hql(Hibernate Query Language), JPQL(Java Persistence Query Language ), NativeSQL

public class StudentService {

    static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {
        //save();
        //update();
        //delete();
        deleteById(5);
    }

    /*public static void save(){
        Student student = new Student("Emre");
        try{
            studentDao.save(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

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
}
