package com.bilgeadam.service;

import com.bilgeadam.entity.Siparis;
import com.bilgeadam.entity.SiparisKalemi;
import com.bilgeadam.repository.SiparisRepository;

import java.util.List;

public class SiparisService {

    SiparisRepository siparisRepository = new SiparisRepository();

    public void save(Siparis siparis){
        siparisRepository.save(siparis);
    }

    public void soru2ASiparisleriListele(){
        List<Siparis> siparisList = siparisRepository.getAll();

        for (Siparis s : siparisList){
            int toplam = 0;
            System.out.println("Siparis ID: " + s.getId() + ", Müşteri Ad-Soyad: " + s.getMusteri().getName() + " " + s.getMusteri().getSurname() + ", Müşteri ID: " + s.getMusteri().getId());
            for (SiparisKalemi sk : s.getSiparisKalemi()){
                System.out.println("        Ürün Adı: " + sk.getUrun().getName() + ", Fiyat: " + sk.getUrun().getPrice() + ", Adet Sayısı: " + sk.getUrunAdedi());
                toplam = toplam + sk.getUrunAdedi() * sk.getUrun().getPrice();
            }
            System.out.println("        Sipariş Toplam: " + toplam);
        }
    }
}
