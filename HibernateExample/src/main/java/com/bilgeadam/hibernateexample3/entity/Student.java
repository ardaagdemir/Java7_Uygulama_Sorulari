package com.bilgeadam.hibernateexample3.entity;

import javax.persistence.*;

//JPQL(Java Persistance Query Language)
//HQL(Hibernate Query Language)

/*
* NamedQuery
* name --> kullanabilmek için bir isim girilmelidir
* query --> tabloya yapılacak sorgu yazılır (JPQL, HQL)
*
* Avantajı --> NativeSQL ve diğer tiplere göre --> Cache'leme yapmaktadır.
* Aynı sorgu veritabanında hiçbir değişiklik olmadan gelirse cache' den önceki sorgu sonucunu getirir.
* Sık değişiklik yapılmayan çok yüksek maliyetli sorgularda tercih edilir.(Aydan aya güncellenen tablolar)
* Ancak her gün güncellenen verilerde kullanılmaz. Yani özel durumlarda kullanılır.
*/

@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "Select s From Student s"), //JPQL yazım biçimidir
        @NamedQuery(name = "Student.findById", query = "Select s From Student s where s.id = :id")
})
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String email;
    private int studentNumber;

    public Student(int id) {
        this.id = id;
    }

    public Student(Integer id, String firstName, String lastName, String email, int studentNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentNumber = studentNumber;
    }

    public Student(String firstName, String lastName, String email, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentNumber = studentNumber;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
