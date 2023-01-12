package com.bilgeadam.join.school_onetomany.repository;

import com.bilgeadam.join.school_onetomany.entity.Okul;
import com.bilgeadam.join.school_onetomany.utils.HibernateUtil;
import org.hibernate.Session;

public class OkulDao {

    public void save(Okul okul){
        try {
           Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(okul);
           session.getTransaction().commit();
           session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //getAll yazılacak
}
