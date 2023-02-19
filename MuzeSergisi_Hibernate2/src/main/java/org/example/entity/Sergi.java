package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sergi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sergiAdi;
    private String sergiBaslangicTarihi;
    private String sergiBitisTarihi;
    private String sergiTemasi;

    @ManyToOne(cascade = CascadeType.ALL)
    private Muze muze;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SanatEseri> sanatEseri;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ziyaretci> ziyaretciList;

    public Sergi(String sergiAdi, String sergiBaslangicTarihi, String sergiBitisTarihi, String sergiTemasi, Muze muze, List<Ziyaretci> ziyaretciList) {
        this.sergiAdi = sergiAdi;
        this.sergiBaslangicTarihi = sergiBaslangicTarihi;
        this.sergiBitisTarihi = sergiBitisTarihi;
        this.sergiTemasi = sergiTemasi;
        this.muze = muze;
        this.ziyaretciList = ziyaretciList;
    }
}
