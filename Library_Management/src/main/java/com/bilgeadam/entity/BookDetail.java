package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookType;
    private String bookDescription;
    private double bookPrice;

    //Uygulamayı yazar tarafından da yöneten arkadaşlar olduğu için burada tanımladık. Aksi halde tanımlamaya gerek yoktur.
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "bookDetail")
    private Book book;*/

    public BookDetail(String bookType, String bookDescription, double bookPrice) {
        this.bookType = bookType;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
    }
}
