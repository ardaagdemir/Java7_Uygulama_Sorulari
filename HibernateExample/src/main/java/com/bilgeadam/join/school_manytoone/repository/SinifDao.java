package com.bilgeadam.join.school_manytoone.repository;

import com.bilgeadam.join.school_manytoone.entity.Sinif;
import com.bilgeadam.join.school_manytoone.utils.HibernateUtil;
import org.hibernate.Session;

public class SinifDao {

    public void save(Sinif sinif){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(sinif);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Kayıt başarısız");
        }
    }
}
