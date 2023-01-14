package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    private Integer id;

    private String firstName;
    private String lastName;

    //Uygulamayı yazar tarafından da yöneten arkadaşlar olduğu için burada tanımladık. Aksi halde tanımlamaya gerek yoktur.
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Book> bookList;*/

    public Author(Integer id) {
        this.id = id;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
