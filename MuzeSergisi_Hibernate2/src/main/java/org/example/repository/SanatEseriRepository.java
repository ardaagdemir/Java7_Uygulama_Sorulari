package org.example.repository;

import org.example.entity.SanatEseri;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

//Spring'de @Repository anotasyonu kullanılır
public class SanatEseriRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();
    public void save(SanatEseri sanatEseri){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sanatEseri);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public List<SanatEseri> findAll(){
        List<SanatEseri> sanatEseriList = null;
        try{
            session.beginTransaction();
            sanatEseriList = session.createQuery("select sanateseri from SanatEseri sanateseri").list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return sanatEseriList;
    }
}
