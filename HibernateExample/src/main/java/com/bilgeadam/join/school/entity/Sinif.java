package com.bilgeadam.join.school.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sinif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lokasyon;

    //OneToOne --> kişi ve tc kimlik no, sinif ve tahta, bilgisayar ve mac adresi, araba ve ruhsat, araba ve plaka
    //CascadeType.ALL --> Bunun sayesinde constructor' da bulunan Lab nesnesi direkt olarak kendi veri tabanında oluşturulmuş olur.
    //Tekrar bir lab nesnesi oluşturup bunu ayrıca veri tabanına eklemeye gerek kalmaz.
    @OneToOne(cascade = CascadeType.ALL)
    private Lab lab;

    @ManyToOne(cascade = CascadeType.ALL)
    private Okul okul;

    @OneToMany
    private List<Dolap> dolaplar;
    /*
    * PERSIST
    * Kaydedilen nesnenin ilişkili nesnesini de kaydeder.
    *
    * MERGE
    * Nesne 'merge' edilirse ilişkili olduğu nesne de 'merge' edilir.
    *
    * REMOVE
    * Nesne silinirse ilişkili olan nesne de silinir.
    *
    * REFRESH
    * Nesne yenilirse bağlı olan nesne de yenilenir.
    *
    * ALL
    * Yukarıdaki bütün işlemler bir arada yapılır.
    * */

    public Sinif() {
    }

    public Sinif(String lokasyon, Lab lab, Okul okul, List<Dolap> dolaplar) {
        this.lokasyon = lokasyon;
        this.lab = lab;
        this.okul = okul;
        this.dolaplar = dolaplar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(String lokasyon) {
        this.lokasyon = lokasyon;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public Okul getOkul() {
        return okul;
    }

    public void setOkul(Okul okul) {
        this.okul = okul;
    }

    public List<Dolap> getDolaplar() {
        return dolaplar;
    }

    public void setDolaplar(List<Dolap> dolaplar) {
        this.dolaplar = dolaplar;
    }

    @Override
    public String toString() {
        return "Sinif{" +
                "id=" + id +
                ", lokasyon='" + lokasyon + '\'' +
                ", lab=" + lab +
                ", okul=" + okul +
                ", dolaplar=" + dolaplar +
                '}';
    }
}
