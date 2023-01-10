package com.bilgeadam.hibernateexample3.repository;

import com.bilgeadam.hibernateexample3.entity.Student;
import com.bilgeadam.hibernateexample3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void startLike(String word){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "from Student where LOWER(firstName) like :word";
            org.hibernate.query.Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("word",word.toLowerCase() + "%");
            List<Student> students = query.getResultList();
            students.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void greaterThan(int number){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "from Student where studentNumber > :key";
            org.hibernate.query.Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("key", number);
            List<Student> students = query.getResultList();
            students.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void betweenStudentNumbers(int number1, int number2){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "from Student where studentNumber between :no1 and :no2";
            org.hibernate.query.Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("no1", number1);
            query.setParameter("no2", number2);
            List<Student> students = query.getResultList();
            students.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //native query --> sql tool' da yazılan pure(saf) sql sorgularıdır
    public List<Student> nativeSQLQuery1(){
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        List<Student> studentList =
                entityManager
                        .createNativeQuery("select id, first_name, lastname, email, studentnumber" +
                                " from student", Student.class).getResultList();
        return studentList;
    }


    public void nativeSQLQuery2(){ //Birden fazla tabloyla çalışırken Obejct[] oluşturulmalıdır.
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        List<Object[]> studentList =
                entityManager
                        .createNativeQuery("select id, first_name, lastname, email, studentnumber" +
                                " from student").getResultList();
        for (Object[] item : studentList){
            System.out.println(
                    "ID: " + item[0] + ", "
                    + "First Name: " + item[1] + ", "
                    + "Last Name: " + item[2] + ", "
                    + "Email: " + item[3] + ", "
                    + "Student Number: " + item[4]
            );
        }
    }
    //çalışma --> nativeQuery --> id ye göre kullanıcı adı ve soyadı getirme
    public void namedQueryFindAllStudents(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        TypedQuery<Student> typedQuery = entityManager.createNamedQuery("Student.findAll", Student.class);
        List<Student> list = typedQuery.getResultList();
        list.forEach(System.out::println);
    }
    public void namedQueryFindById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        TypedQuery<Student> typedQuery = entityManager.createNamedQuery("Student.findById", Student.class);
        typedQuery.setParameter("id", id);
        List<Student> list = typedQuery.getResultList();
        list.forEach(System.out::println);
    }



}
