package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int urunAdedi;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Urun urun;

    public SiparisKalemi(Urun urun, int urunAdedi) {
        this.urunAdedi = urunAdedi;
        this.urun = urun;
    }
}
