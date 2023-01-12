package com.bilgeadam.join.school_manytoone.service;

import com.bilgeadam.join.school_manytoone.entity.Dolap;
import com.bilgeadam.join.school_manytoone.entity.Lab;
import com.bilgeadam.join.school_manytoone.entity.Okul;
import com.bilgeadam.join.school_manytoone.entity.Sinif;
import com.bilgeadam.join.school_manytoone.repository.SinifDao;

import java.util.Arrays;

public class SinifService {
    public static void main(String[] args) {
        //save();
        getAll();
    }

    private static SinifDao sinifDao = new SinifDao();

    public static void save(){
        try{
            Lab lab1 = new Lab("D Blok Giriş Kat 20'nolu Laboratuvar");
            Dolap dolap1 = new Dolap("10");
            Okul okul1 = new Okul("Ahmet Yesevi İlköğretim");

            Sinif sinif1 = new Sinif("D Blok 2.Kat 15 nolu Sınıf", lab1, Arrays.asList(dolap1), okul1);
            sinifDao.save(sinif1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getAll(){
        sinifDao.getAll();
    }
}
