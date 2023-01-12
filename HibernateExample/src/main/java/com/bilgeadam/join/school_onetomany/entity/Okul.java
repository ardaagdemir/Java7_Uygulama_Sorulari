package com.bilgeadam.join.school_onetomany.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Okul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String okulAd;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sinif> siniflar;

    public Okul() {
    }

    public Okul(String okulAd, List<Sinif> siniflar) {
        this.okulAd = okulAd;
        this.siniflar = siniflar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOkulAd() {
        return okulAd;
    }

    public void setOkulAd(String okulAd) {
        this.okulAd = okulAd;
    }

    public List<Sinif> getSiniflar() {
        return siniflar;
    }

    public void setSiniflar(List<Sinif> siniflar) {
        this.siniflar = siniflar;
    }

    @Override
    public String toString() {
        return "Okul{" +
                "id=" + id +
                ", okulAd='" + okulAd + '\'' +
                ", siniflar=" + siniflar +
                '}';
    }
}
