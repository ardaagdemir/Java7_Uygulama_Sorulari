package com.bilgeadam.join.school.repository;

import com.bilgeadam.join.school.entity.Sinif;
import com.bilgeadam.join.school.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SinifDao implements ICrud<Sinif> {

    @Override
    public void save(Sinif sinif) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sinif);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
