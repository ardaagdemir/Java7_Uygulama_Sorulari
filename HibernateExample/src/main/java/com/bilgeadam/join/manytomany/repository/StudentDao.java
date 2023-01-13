package com.bilgeadam.join.manytomany.repository;

import com.bilgeadam.join.manytomany.entity.Student;
import com.bilgeadam.join.manytomany.utils.HibernateUtil;
import org.hibernate.Session;

public class StudentDao {

    public void save(Student student){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
