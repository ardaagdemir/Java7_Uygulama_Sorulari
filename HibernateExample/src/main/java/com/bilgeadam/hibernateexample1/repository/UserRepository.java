package com.bilgeadam.hibernateexample1.repository;

import com.bilgeadam.hibernateexample1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserRepository implements ICrud<User>{

    protected SessionFactory sessionFactory;

    public void setup() {
        final StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch(Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction(); //oturum oluşturur
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    public void exit() {
        sessionFactory.close();
    }
}
