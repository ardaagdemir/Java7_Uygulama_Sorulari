package com.bilgeadam.join.school_manytoone.utils;


import com.bilgeadam.join.school_manytoone.entity.Dolap;
import com.bilgeadam.join.school_manytoone.entity.Lab;
import com.bilgeadam.join.school_manytoone.entity.Okul;
import com.bilgeadam.join.school_manytoone.entity.Sinif;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Dolap.class);
                configuration.addAnnotatedClass(Lab.class);
                configuration.addAnnotatedClass(Okul.class);
                configuration.addAnnotatedClass(Sinif.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
