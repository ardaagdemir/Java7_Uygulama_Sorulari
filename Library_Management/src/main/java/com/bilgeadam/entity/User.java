package com.bilgeadam.entity;

import com.bilgeadam.utils.EUserGender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private String age;

    @Enumerated(EnumType.STRING)
    private EUserGender userGender;
    private String maritalStatus;

    //Uygulamayı yazar tarafından da yöneten arkadaşlar olduğu için burada tanımladık. Aksi halde tanımlamaya gerek yoktur.
    /*@ManyToMany(mappedBy = "userList")
    public List<Book> books;*/

    public User(String fullName, String age, EUserGender userGender, String maritalStatus) {
        this.fullName = fullName;
        this.age = age;
        this.userGender = userGender;
        this.maritalStatus = maritalStatus;
    }
}
