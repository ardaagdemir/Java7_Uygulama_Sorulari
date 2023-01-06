package com.bilgeadam.hibernateexample2.manager;

import com.bilgeadam.hibernateexample2.entity.Ogretmen;
import com.bilgeadam.hibernateexample2.repository.OgretmenDao;

public class OgretmenManager {

    static OgretmenDao ogretmenDao = new OgretmenDao();

    public static void main(String[] args) {
        save();
    }

    public static void save(){
        Ogretmen ogretmen = new Ogretmen("Bertan", "Bilir");
        try{
            ogretmenDao.save(ogretmen);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
