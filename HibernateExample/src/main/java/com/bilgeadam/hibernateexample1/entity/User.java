package com.bilgeadam.hibernateexample1.entity;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 25)
    private String username;
    @Column(length = 32)
    private String password;
    @Column(length = 25)
    private String city;
    @Column(length = 255)
    private String address;

    public User() {
    }

    /*public User(String username, String password, String city, String address) {
        this.username = username;
        this.password = password;
        this.city = city;
        this.address = address;
    }*/

    /*public User(Integer id, String username, String password, String city, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.city = city;
        this.address = address;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
