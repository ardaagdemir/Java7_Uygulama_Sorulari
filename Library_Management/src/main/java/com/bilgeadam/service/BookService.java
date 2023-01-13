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
        //save();
        //getAll();
        //getById(1);
        //getByIdFromNativeQuery(2);
        //getByIdFromNativeQuery2(1);
        //update();
        //delete(3);
    }

    static BookDao bookDao = new BookDao();
    public static void save(){
        BookDetail bookDetail = new BookDetail("History", "The book is wonderful!", 120);
        User user1 = new User("Tunç Cenk Ergüven", "26", EUserGender.MALE, "Single");
        User user2 = new User("Emre Kazancı", "45", EUserGender.MALE, "Single");

        Author author = new Author("James", "Clean");

        Book book1 = new Book("Atomik Alışkanlıklar", author, bookDetail, Arrays.asList(user1, user2));

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

}
