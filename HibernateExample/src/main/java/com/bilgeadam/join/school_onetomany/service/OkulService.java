package com.bilgeadam.join.school_onetomany.service;


import com.bilgeadam.join.school_onetomany.entity.Dolap;
import com.bilgeadam.join.school_onetomany.entity.Lab;
import com.bilgeadam.join.school_onetomany.entity.Okul;
import com.bilgeadam.join.school_onetomany.entity.Sinif;
import com.bilgeadam.join.school_onetomany.repository.OkulDao;

import java.util.Arrays;

public class OkulService {

    public static void main(String[] args) {
        save();
    }

    static OkulDao okulDao = new OkulDao();

    public static void save(){
        Lab lab1 = new Lab("D Blok Giriş Kat 20'nolu Laboratuvar");
        Dolap dolap1 = new Dolap("10");
        Sinif sinif1 = new Sinif("D Blok 2.Kat 15 nolu Sınıf", lab1, Arrays.asList(dolap1));

        Lab lab2 = new Lab("B Blok 1. Kat 10'nolu Laboratuvar");
        Dolap dolap2 = new Dolap("5");
        Sinif sinif2 = new Sinif("B Blok 3.Kat 25 nolu Sınıf", lab2, Arrays.asList(dolap2));

        Okul okul1 = new Okul("Deneme İlköğretim Okulu", Arrays.asList(sinif1,sinif2));
        try {
            okulDao.save(okul1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
