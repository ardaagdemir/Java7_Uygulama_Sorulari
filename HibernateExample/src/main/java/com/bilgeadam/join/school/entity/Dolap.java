package com.bilgeadam.join.school.entity;

import javax.persistence.*;

@Entity
public class Dolap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dolapNo;

    public Dolap() {
    }

    public Dolap(String dolapNo) {
        this.dolapNo = dolapNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDolapNo() {
        return dolapNo;
    }

    public void setDolapNo(String dolapNo) {
        this.dolapNo = dolapNo;
    }
}
