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
        getAll();
    }

    static BookDao bookDao = new BookDao();
    public static void save(){
        BookDetail bookDetail = new BookDetail("History", "The book is great!", 120);
        User user1 = new User("Arda Ağdemir", "26", EUserGender.MALE, "Single");
        User user2 = new User("Emre Kazancı", "45", EUserGender.MALE, "Single");
        Author author = new Author("Bernard", "Lewis");

        Book book1 = new Book("Modern Türkiyenin Doğuşu", author, bookDetail, Arrays.asList(user1, user2));

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

}
