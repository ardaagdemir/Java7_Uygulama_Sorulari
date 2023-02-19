package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Ziyaretci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ziyaretciAdi;
    private int yas;
    private String telefonNo;
    @ManyToMany
    private List<Sergi> sergiList;

    public Ziyaretci(String ziyaretciAdi, int yas, String telefonNo) {
        this.ziyaretciAdi = ziyaretciAdi;
        this.yas = yas;
        this.telefonNo = telefonNo;
    }
}
