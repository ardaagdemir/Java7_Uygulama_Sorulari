package com.bilgeadam.hibernateexample3.repository;

import com.bilgeadam.hibernateexample3.entity.Student;
import com.bilgeadam.hibernateexample3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;


public class StudentDao {

    //hql queries
    public void save(Student student) throws Exception {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();

            session.save(student);

            transaction.commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("kayıt başarısız!");
        }
    }

    public void update(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            String hql = "Update Student set firstName= :firstName, lastName= :lastName, email= :email, studentNumber= :studentNumber " +
                    "where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", student.getId());
            query.setParameter("lastName", student.getLastName());
            query.setParameter("firstName", student.getFirstName());
            query.setParameter("studentNumber", student.getStudentNumber());
            query.setParameter("email", student.getEmail());
            query.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(Student student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "delete from Student where id= :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", student.getId());
            query.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "delete from Student where id= :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
