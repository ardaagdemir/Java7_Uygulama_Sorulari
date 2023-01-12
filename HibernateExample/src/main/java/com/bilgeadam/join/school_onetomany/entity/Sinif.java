package com.bilgeadam.join.school_onetomany.entity;

import com.bilgeadam.join.school_manytoone.entity.Okul;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Sinif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sinifLokasyon;

    @OneToOne(cascade = CascadeType.ALL)
    private Lab lab;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dolap> dolaplar;


    public Sinif() {
    }

    public Sinif(String sinifLokasyon, Lab lab, List<Dolap> dolaplar) {
        this.sinifLokasyon = sinifLokasyon;
        this.lab = lab;
        this.dolaplar = dolaplar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSinifLokasyon() {
        return sinifLokasyon;
    }

    public void setSinifLokasyon(String sinifLokasyon) {
        this.sinifLokasyon = sinifLokasyon;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public List<Dolap> getDolap() {
        return dolaplar;
    }

    public void setDolap(List<Dolap> dolap) {
        this.dolaplar = dolap;
    }


    @Override
    public String toString() {
        return "Sinif{" +
                "id=" + id +
                ", sinifLokasyon='" + sinifLokasyon + '\'' +
                ", lab=" + lab +
                ", dolap=" + dolaplar +
                '}';
    }
}
