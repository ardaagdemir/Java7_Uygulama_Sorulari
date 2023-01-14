package com.bilgeadam.service;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.entity.User;
import com.bilgeadam.repository.BookDao;
import com.bilgeadam.utils.EUserGender;

import java.util.Arrays;

public class BookService {

    public static void main(String[] args) {
        save();
        //getAll();
        //getById(1);
        //getByIdFromNativeQuery(2);
        //getByIdFromNativeQuery2(1);
        //update();
        delete(5);
        //delete2();
        //getByName("geleceği");
    }

    static BookDao bookDao = new BookDao();
    public static void save(){
        BookDetail bookDetail = new BookDetail("Science", "", 60);
        User user1 = new User("Mücahit Doğan", "26", EUserGender.FEMALE, "Single");

        Author author = new Author(1,"Carl", "Sagan");

        Book book1 = new Book("Deneme3", author, bookDetail, Arrays.asList(user1));

        try{
            bookDao.save(book1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getAll(){
        try{
            bookDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getById(int id){
        bookDao.getById(id);
    }
    public static void getByIdFromNativeQuery(int id){
        bookDao.getByIdFromNativeQuery(id);
    }
    public static void getByIdFromNativeQuery2(int id){
        bookDao.getByIdFromNativeQuery2(id);
    }
    public static void update(){
        try {
            BookDetail bookDetail = new BookDetail("Science", "The book is wonderful", 90);
            User user1 = new User(4,"Tunç Cenk Ergüven", "26", EUserGender.MALE, "Single");

            Author author = new Author(3,"Yuval N.", "Harari");

            Book book1 = new Book(2,"Sapiens", author, bookDetail, Arrays.asList(user1));
            bookDao.update(book1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(int id){
        bookDao.delete(id);
    }
    public static void delete2(){
        try {
            BookDetail bookDetail = new BookDetail(3);
            User user1 = new User(3);

            Author author = new Author(1,"Carl", "Sagan");

            Book book1 = new Book(3, author, bookDetail, Arrays.asList(user1));

            bookDao.delete2(book1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getByName(String word){
        try {
            bookDao.getByName(word);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
