package org.example.util;

import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Sanatci.class);
                configuration.addAnnotatedClass(Muze.class);
                configuration.addAnnotatedClass(Sergi.class);
                configuration.addAnnotatedClass(SanatEseri.class);
                configuration.addAnnotatedClass(Ziyaretci.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
