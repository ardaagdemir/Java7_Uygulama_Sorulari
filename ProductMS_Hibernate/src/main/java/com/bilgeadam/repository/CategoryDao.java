package com.bilgeadam.repository;

import com.bilgeadam.entity.Category;
import com.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;

public class CategoryDao {

    public void create(Category entity) {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(entity);
            session.getTransaction().commit();
            System.out.println("Category data is added to DB");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Some problem occured while adding Category data");
        } finally {
            session.close();
        }
    }
}
