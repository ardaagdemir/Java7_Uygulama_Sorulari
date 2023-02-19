package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Muze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String muzeAdi;
    private String sehir;
    private String acilisSaati;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Sergi> sergiList;

    public Muze(String muzeAdi, String sehir, String acilisSaati) {
        this.muzeAdi = muzeAdi;
        this.sehir = sehir;
        this.acilisSaati = acilisSaati;
    }
}
