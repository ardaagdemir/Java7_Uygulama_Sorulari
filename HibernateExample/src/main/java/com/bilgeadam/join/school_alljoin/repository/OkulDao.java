package com.bilgeadam.join.school_alljoin.repository;

import com.bilgeadam.join.school_alljoin.entity.Okul;
import com.bilgeadam.join.school_alljoin.utils.HibernateUtil;
import org.hibernate.Session;

public class OkulDao implements ICrud<Okul> {
    @Override
    public void save(Okul okul) {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(okul);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
