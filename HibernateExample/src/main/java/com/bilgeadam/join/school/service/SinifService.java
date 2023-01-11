package com.bilgeadam.join.school.service;

import com.bilgeadam.join.school.entity.Dolap;
import com.bilgeadam.join.school.entity.Lab;
import com.bilgeadam.join.school.entity.Okul;
import com.bilgeadam.join.school.entity.Sinif;
import com.bilgeadam.join.school.repository.SinifDao;
import java.util.Arrays;
import java.util.List;

public class SinifService {
    private static SinifDao sinifDao = new SinifDao();

    public static void main(String[] args) {
        save();
    }

    public static void save(){
        Lab lab1 = new Lab(1, "B Blok, 1.Kat, Lab40");
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
}
