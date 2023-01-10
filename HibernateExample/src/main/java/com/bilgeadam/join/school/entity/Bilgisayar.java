package com.bilgeadam.join.school.entity;

import javax.persistence.*;

@Entity
public class Bilgisayar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //OneToOne --> kişi ve tc kimlik no, sinif ve tahta, bilgisayar ve mac adresi, araba ve ruhsat, araba ve plaka

    @OneToOne(cascade = CascadeType.ALL)
    private MacAddress macAddress;

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

}
