package com.bilgeadam.hibernateexample1.repository;

import com.bilgeadam.hibernateexample1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class UserRepository implements ICrud<User>{

    protected SessionFactory sessionFactory;

    public void setup() {
        final StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory= new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch(Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }finally {
            //Yukarıdaki satırlarda(try-catch) hata olsun veya olmasın çalışacak kod bloğudur.
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

    @Override
    public List<User> getAll() {
        List<User> userList = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction(); //veritabanında bir değişiklik yapılmadığında yazılması gerekmez(örneğin --> her türlü 'get' işlemi)
            Query query = session.createQuery("from User");
            userList = query.getResultList();
            //userList = session.createQuery("from User").list();  --> alternatif kullanım

            session.getTransaction().commit();//veritabanında bir değişiklik yapılmadığında yazılması gerekmez(örneğin --> her türlü 'get' işlemi)
        }catch (Exception e){
            if (userList.isEmpty()){
                System.out.println("Liste boş");
            }
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close(); //opsiyonel
        }catch (Exception e){
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            User user = session.load(User.class, id);
            //Alternatif yol 1
            //User user = session.find(User.class, id)

            //Alternatif yol 2
            /*Query query = session.createQuery("from User where Id = :id");
            query.setParameter("id",id);
            User user = (User)query.getResultList().get(0);*/

            session.delete(user);
            session.getTransaction().commit();
            System.out.println("Kayıt silindi");
            session.close();
        }catch (Exception e){
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        try{
           session.beginTransaction();
           session.delete(user);
           session.getTransaction().commit();
           System.out.println("Kayıt silindi");
        }catch (Exception e){
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = null;
        try{
            user = session.get(User.class, id);
        }catch (Exception e){
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
        return user;
    }

    public void exit() {
        sessionFactory.close();
    }
}
