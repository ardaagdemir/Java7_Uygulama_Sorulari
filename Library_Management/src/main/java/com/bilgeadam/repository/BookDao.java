package com.bilgeadam.repository;

import com.bilgeadam.entity.Book;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

public class BookDao {

    public void save(Book book){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            System.out.println("Book data is added");
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
