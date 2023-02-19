package com.bilgeadam.repository;

import com.bilgeadam.entity.Siparis;
import com.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SiparisRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public void save(Siparis siparis){
        try{

            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            e.getCause();
        }
    }

    public List<Siparis> getAll(){
        List<Siparis> list = null;
        try {
            session.beginTransaction();
            list = session.createQuery("select siparis from Siparis siparis").list(); //jpql --> java persistence query language
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
