package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Siparis> siparisList;

    public Musteri(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
