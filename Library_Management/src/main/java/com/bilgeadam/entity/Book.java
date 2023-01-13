package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    @OneToOne(cascade = CascadeType.ALL)
    private BookDetail bookDetail;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> userList;

    public Book(String bookName, Author author, BookDetail bookDetail, List<User> userList) {
        this.bookName = bookName;
        this.author = author;
        this.bookDetail = bookDetail;
        this.userList = userList;
    }

    public Book(Integer id, String bookName, Author author, BookDetail bookDetail, List<User> userList) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.bookDetail = bookDetail;
        this.userList = userList;
    }
}
