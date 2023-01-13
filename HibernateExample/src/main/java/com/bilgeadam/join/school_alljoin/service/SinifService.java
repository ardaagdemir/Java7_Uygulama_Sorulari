package com.bilgeadam.join.school_alljoin.service;

import com.bilgeadam.join.school_alljoin.entity.Dolap;
import com.bilgeadam.join.school_alljoin.entity.Lab;
import com.bilgeadam.join.school_alljoin.entity.Okul;
import com.bilgeadam.join.school_alljoin.entity.Sinif;
import com.bilgeadam.join.school_alljoin.repository.OkulDao;
import com.bilgeadam.join.school_alljoin.repository.SinifDao;


import java.util.Arrays;
import java.util.List;

public class SinifService {
    private static SinifDao sinifDao = new SinifDao();
    private static OkulDao okulDao = new OkulDao();

    public static void main(String[] args) {
        //saveSinif();
        //saveOkul();
        getAll();
    }

    public static void saveSinif(){
        Lab lab1 = new Lab("B Blok, 1.Kat, Lab40");
        Okul okul1 = new Okul(" NoterlerBirliği İlköğretim Okulu");

        Dolap dolap1 = new Dolap("3");
        Dolap dolap2 = new Dolap("4");
        List<Dolap> dolaplar = Arrays.asList(dolap1, dolap2);

        Sinif sinif1 = new Sinif(
                " Blok, 1.Kat, 40 numaralı sınıf",
                lab1,
                okul1,
                dolaplar
        );

        sinifDao.save(sinif1);
    }

    public static void saveOkul(){
        Lab lab1 = new Lab("C Blok, 1.Kat, Lab40");

        Dolap dolap1 = new Dolap("5");
        Dolap dolap2 = new Dolap("6");
        List<Dolap> dolaplar = Arrays.asList(dolap1, dolap2);
        Sinif sinif1 = new Sinif("lokasyon", lab1, dolaplar);

        Lab lab2 = new Lab("B Blok, 1.Kat, Lab40");

        Dolap dolap3 = new Dolap("7");
        Dolap dolap4 = new Dolap("8");
        List<Dolap> dolaplar2 = Arrays.asList(dolap3, dolap4);
        Sinif sinif2 = new Sinif("lokasyon2", lab2, dolaplar2);

        List<Sinif> sinifListesi = Arrays.asList(sinif1, sinif2);
        Okul okul1 = new Okul("okul adi", sinifListesi);

        okulDao.save(okul1);
    }

    public static void getAll(){
        sinifDao.getAll();
    }
}
