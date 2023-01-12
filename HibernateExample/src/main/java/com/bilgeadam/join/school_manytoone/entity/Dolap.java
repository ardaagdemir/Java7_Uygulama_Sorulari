package com.bilgeadam.join.school_manytoone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @Override
    public String toString() {
        return "Dolap{" +
                "id=" + id +
                ", dolapNo='" + dolapNo + '\'' +
                '}';
    }
}