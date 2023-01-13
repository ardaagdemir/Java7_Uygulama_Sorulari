package com.bilgeadam.join.manytomany.utils;

import com.bilgeadam.join.manytomany.entity.Course;
import com.bilgeadam.join.manytomany.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Course.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
