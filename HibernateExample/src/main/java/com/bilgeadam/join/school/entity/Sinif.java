package com.bilgeadam.join.school.entity;

import javax.persistence.*;

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

    @ManyToOne()
    private Okul okul;
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

    public Sinif(String lokasyon, Lab lab) {
        this.lokasyon = lokasyon;
        this.lab = lab;
    }
}