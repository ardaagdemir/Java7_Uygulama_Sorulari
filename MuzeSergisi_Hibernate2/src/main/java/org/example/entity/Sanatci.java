package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sanatci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sanatciAdi;
    private int dogumYili;
    private int olumYili;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SanatEseri> sanatEseriList;

    public Sanatci(String sanatciAdi, int dogumYili, int olumYili) {
        this.sanatciAdi = sanatciAdi;
        this.dogumYili = dogumYili;
        this.olumYili = olumYili;
    }
}
