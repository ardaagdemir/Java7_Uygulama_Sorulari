package com.bilgeadam.hibernateexample2.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/*Araştırma
* Lombok kütüphanesi
* */

/*entity katmanı --> veritabanında oluşturulan tabloların ilişki kurduğu classların bulunduğu katmandır.
Bu katmandaki class'ların veritabanı ile ilişki kurması gerekli değildir.
İçerisinde property' si olan her türlü class bu katmana yazılır ve bu katmandaki class'lara "entity class'lar" denir
*/
//Annotation --> @...
@Entity //bir veritabanı class' ıdır
@Table(name = "teacher")
public class Ogretmen {

    @Id //Primary key olduğunu gösterir
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false) //ogretmen tablosundaki name kolonu boş olamaz
    private String name;

    @Column(nullable = false, length = 20) //en fazla 20 karakter uzunluğunda olabilir
    private String surname;

    @Column(nullable = true, columnDefinition = "int default 18") //columnDefinition --> veritabanındaki ilgili kolonun default değerini belirlemeye yarar
    private int age;

    @ColumnDefault(value = "2") //ilgili kolonun default değerini belirlemek için kullanılır
    @Column(nullable = false)
    private int serviceYear;

    //3(ad,soyad, yaş),4(ad, soyad, yaş, hizmetyılı) ve 5 parametreli constructor
    public Ogretmen() {
    }

    public Ogretmen(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = 18;
    }

    public Ogretmen(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Ogretmen(String name, String surname, int age, int serviceYear) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.serviceYear = serviceYear;
    }

    public Ogretmen(Integer id, String name, String surname, int age, int serviceYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.serviceYear = serviceYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getServiceYear() {
        return serviceYear;
    }

    public void setServiceYear(int serviceYear) {
        this.serviceYear = serviceYear;
    }

    @Override
    public String toString() {
        return "Ogretmen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", serviceYear=" + serviceYear +
                '}';
    }
}
