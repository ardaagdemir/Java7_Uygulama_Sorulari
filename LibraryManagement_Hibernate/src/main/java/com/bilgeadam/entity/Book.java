package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Author author;

    @OneToOne(cascade = CascadeType.ALL)
    private BookDetail bookDetail;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> userList;

    public Book(String bookName, BookDetail bookDetail, List<User> userList) {
        this.bookName = bookName;
        this.bookDetail = bookDetail;
        this.userList = userList;
    }

    public Book(Integer id, Author author, BookDetail bookDetail, List<User> userList) {
        this.id = id;
        this.author = author;
        this.bookDetail = bookDetail;
        this.userList = userList;
    }

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

     /*
    *PERSIST
	İlişki persist olarak tanımlandıysa kaydedilen nesnenin alt nesneside kaydedilir.

	MERGE
	İlişki merge olarak tanımlandıysa nesne merge edilirse ilişkili olan nesne de merge edilir.

	REMOVE
	İlişki remove olarak tanımlandıysa nesne silinirse ilişkili olan nesne de silinir.

	REFRESH
	İlişki refresh olarak tanımlandıysa nesne yenilenirse bağlı olan nesne de yenilenir.

	ALL
	İlişki all olarak tanımlandıysa yukarıdaki tüm işlemler için birlikte yapılır.
    * */
}
