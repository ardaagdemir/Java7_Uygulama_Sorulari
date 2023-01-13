package com.bilgeadam.join.school_manytoone.entity;

import javax.persistence.*;

@Entity
public class Okul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String okulAdi;


    public Okul() {
    }

    public Okul(String okulAdi) {
        this.okulAdi = okulAdi;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    @Override
    public String toString() {
        return "Okul{" +
                "id=" + id +
                ", okulAdi='" + okulAdi + '\'' +
                '}';
    }
}