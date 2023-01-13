package com.bilgeadam.repository;

import com.bilgeadam.entity.Book;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

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

    public void getAll(){
        List<Object[]> bookList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select b.id, b.bookname, a.firstName, a.lastName, bd.bookDescription, bd.bookPrice, bd.bookType, u.fullName, u.maritalStatus, u.userGender " +
                    "from book as b \n" +
                    "inner join author as a ON a.id = b.author_id \n" +
                    "inner join bookdetail as bd ON bd.id = b.bookDetail_id\n" +
                    "inner join book_user as bu on b.id = bu.book_id\n" +
                    "inner join user as u on bu.userList_id = u.id";
            bookList = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item : bookList){
                System.out.println("ID: " + item[0] + " --"
                        + " Book Name: " + item[1] + " --"
                        + " Name: " + item[2] + " " + item[3] + " --"
                        + " Description: " + item[4] + " --"
                        + " Price: " + item[5] + " --"
                        + " Book Type: " + item[6]
                        + " User Name: " + item[7]
                        + " Marital Status: " + item[8]
                        + " Gender: " + item[9]
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //getAll2' u hibernate metotlarını kullanarak uygulayınız

    public void getById(int id){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Book book = session.load(Book.class, id);
            System.out.println(book);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getByIdFromNativeQuery(int id){


    }
}
