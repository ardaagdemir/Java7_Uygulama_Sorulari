package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SanatEseri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eserAdi;
    private int yapimYili;
    @ManyToOne(cascade = CascadeType.ALL)
    private Sanatci sanatci;
    @ManyToOne(cascade = CascadeType.ALL)
    private Sergi sergi;

    public SanatEseri(String eserAdi, int yapimYili, Sanatci sanatci, Sergi sergi) {
        this.eserAdi = eserAdi;
        this.yapimYili = yapimYili;
        this.sanatci = sanatci;
        this.sergi = sergi;
    }
}
