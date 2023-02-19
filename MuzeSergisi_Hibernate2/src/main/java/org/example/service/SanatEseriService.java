package org.example.service;

import org.example.entity.*;
import org.example.repository.SanatEseriRepository;

import java.util.Arrays;
import java.util.List;

public class SanatEseriService {

    static SanatEseriRepository sanatEseriRepository = new SanatEseriRepository();

    public static void save(){
        /**
         * SanatEseri --> Sanatci ve Sergi ile ilişkisi var.
         * Sergi --> Müze ve Ziyaretçi ile ilişkisi var.
         */
        Muze muze = new Muze("Müze1", "Ankara", "10:00");
        Ziyaretci ziyaretci = new Ziyaretci("ziyaretçi1", 25, "1231512314");

        Sergi sergi = new Sergi("Sergi1", "12.02.2023","19.02.2023","gods", muze, Arrays.asList(ziyaretci));
        Sanatci sanatci = new Sanatci("Artist1", 1923, 2023);

        SanatEseri sanatEseri = new SanatEseri("Eser1", 2000, sanatci, sergi);
        sanatEseriRepository.save(sanatEseri);
    }

    public static void findAll(){
        List<SanatEseri> list = sanatEseriRepository.findAll();
        for (SanatEseri item : list){
            System.out.println(
                    "Eser Adı: " + item.getEserAdi()
                    + " Eser Yapım Yılı: " + item.getYapimYili()
                    + " Eserin Sanatçısı: " + item.getSanatci().getSanatciAdi()
                    + " Eser sergilendiği Sergi: " + item.getSergi().getSergiAdi()
                    );
            for (Ziyaretci item2 : item.getSergi().getZiyaretciList()){
                System.out.println(" Ziyaretçi Adı: " + item2.getZiyaretciAdi());
            }
        }
    }
}
