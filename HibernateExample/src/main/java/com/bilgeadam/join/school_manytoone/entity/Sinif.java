package com.bilgeadam.join.school_manytoone.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Sinif {

    @Id
    @GeneratedValue(generator = "SequenceSinifId", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SequenceSinifId", sequenceName = "sinif_seq", initialValue = 100, allocationSize = 10)
    private Integer id;

    private String sinifLokasyon;

    @OneToOne(cascade = CascadeType.ALL)
    private Lab lab;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dolap> dolaplar;

    @ManyToOne(cascade = CascadeType.ALL)
    private Okul okul;


    public Sinif() {
    }

    public Sinif(String sinifLokasyon, Lab lab, List<Dolap> dolaplar, Okul okul) {
        this.sinifLokasyon = sinifLokasyon;
        this.lab = lab;
        this.dolaplar = dolaplar;
        this.okul = okul;
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

    public Okul getOkul() {
        return okul;
    }

    public void setOkul(Okul okul) {
        this.okul = okul;
    }

    @Override
    public String toString() {
        return "Sinif{" +
                "id=" + id +
                ", sinifLokasyon='" + sinifLokasyon + '\'' +
                ", lab=" + lab +
                ", dolap=" + dolaplar +
                ", okul=" + okul +
                '}';
    }
}
