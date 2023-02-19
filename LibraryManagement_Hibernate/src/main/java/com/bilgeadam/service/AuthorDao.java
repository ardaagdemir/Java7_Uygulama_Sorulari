package com.bilgeadam.service;

import com.bilgeadam.entity.Author;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

public class AuthorDao {

    public void save(Author author){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }
}
