package com.bilgeadam.repository;

import com.bilgeadam.entity.Book;
import com.bilgeadam.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public void getByIdFromNativeQuery(Integer id){
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
                if (id.equals(item[0]))
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

    public void getByIdFromNativeQuery2(int id){
        List<Object[]> bookList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String sql = "select b.id, b.bookname, a.firstName, a.lastName, bd.bookDescription, bd.bookPrice, bd.bookType, u.fullName, u.maritalStatus, u.userGender " +
                    "from book as b \n" +
                    "inner join author as a ON a.id = b.author_id \n" +
                    "inner join bookdetail as bd ON bd.id = b.bookDetail_id\n" +
                    "inner join book_user as bu on b.id = bu.book_id\n" +
                    "inner join user as u on bu.userList_id = u.id where b.id = ?";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, id);
            bookList = query.getResultList();
            for(Object[] item : bookList){
                    System.out.println("ID: " + item[0] + " --"
                            + " Book Name: " + item[1] + " --"
                            + " Name: " + item[2] + " " + item[3] + " --"
                            + " Description: " + item[4] + " --"
                            + " Price: " + item[5] + " --"
                            + " Book Type: " + item[6] + " --"
                            + " User Name: " + item[7] + " --"
                            + " Marital Status: " + item[8] + " --"
                            + " Gender: " + item[9]
                    );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(Book book){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(book);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(int id){
        Session session = null;
        Book book = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            book = session.load(Book.class, id);
            session.delete(book);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            //rollback kontrolü yapılabilir
        }
    }

    public void delete2(Book book){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(book);
            session.getTransaction().commit();
            System.out.println("Book is deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            e.getCause();
        }
    }

    public void getByName(String word){
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        String sql = "select b.id, b.bookname, a.firstName, a.lastName, bd.bookDescription, bd.bookPrice, bd.bookType, u.fullName, u.maritalStatus, u.userGender \n" +
                "                    from book as b \n" +
                "                    inner join author as a ON a.id = b.author_id\n" +
                "                    inner join bookdetail as bd ON bd.id = b.bookDetail_id\n" +
                "                     inner join book_user as bu on b.id = bu.book_id\n" +
                "inner join user as u on bu.userList_id = u.id where b.bookname like ?";
        try {
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter(1, "%" + word+ "%"); //%word%
            List<Object[]> array = query.getResultList();
            for(Object[] item : array){
                System.out.println("ID: " + item[0] + " --"
                        + " Book Name: " + item[1] + " --"
                        + " Name: " + item[2] + " " + item[3] + " --"
                        + " Description: " + item[4] + " --"
                        + " Price: " + item[5] + " --"
                        + " Book Type: " + item[6] + " --"
                        + " User Name: " + item[7] + " --"
                        + " Marital Status: " + item[8] + " --"
                        + " Gender: " + item[9]
                );
            }
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

}
