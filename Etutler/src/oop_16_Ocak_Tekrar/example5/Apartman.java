package oop_16_Ocak_Tekrar.example5;

import java.util.ArrayList;
import java.util.List;

public class Apartman extends Bina{

    private String gorevli;
    private final double AIDAT_ODEMESI = 100;
    private List<Kisi> kisiler;

    public Apartman(String adres, String sehir, String postaKodu, double aylikKira, String gorevli) {
        super(adres, sehir, postaKodu, aylikKira);
        this.gorevli = gorevli;
        kisiler = new ArrayList<>();
    }

    @Override
    public void binaBilgileriniGoster() {
        System.out.println("Apartman Genel Bilgileri: " + super.toString() + ", Görevli: " + getGorevli());
    }

    @Override
    public void iletisimBilgileriniGoster() {
        for (Kisi item : kisiler){
            System.out.println("Apartman Sakini İsim: " + item.getIsim() + ", Telefon Numarası: " + item.getTelNo());
        }
    }

    @Override
    public void gorevliMaasıOde() {
        System.out.println(getGorevli() + " 'nin maaşı ödendi: " + (AIDAT_ODEMESI * 10));
    }

    @Override
    public void yasayanlariGoster() {
        System.out.println("Apartmanda yaşayan kişiler");
        for (int i=0; i<kisiler.size(); i++){
            System.out.println("Apartmanda yaşayan kişinin soyadı --> " + kisiler.get(i).getSoyad());
        }
    }

    @Override
    public void kiraOdeme() {
        System.out.println("Kira ödendi: " + (getAylikKira() + AIDAT_ODEMESI));
    }

    @Override
    public void insanEkle(User kisi) {
        if (kisi instanceof Kisi){
            kisiler.add((Kisi)kisi);
            System.out.println("Apartmana " + ((Kisi)kisi).getIsim() + " " + kisi.getSoyad() + " isimli kişi eklendi.");
        }else {
            System.out.println("Apartmana aile eklenemez.");
        }
    }


    public String getGorevli() {
        return gorevli;
    }

    public void setGorevli(String gorevli) {
        this.gorevli = gorevli;
    }

    public double getAIDAT_ODEMESI() {
        return AIDAT_ODEMESI;
    }

    public List<Kisi> getKisiler() {
        return kisiler;
    }

    public void setKisiler(List<Kisi> kisiler) {
        this.kisiler = kisiler;
    }

    @Override
    public String toString() {
        return "Apartman{" +
                "gorevli='" + gorevli + '\'' +
                ", AIDAT_ODEMESI=" + AIDAT_ODEMESI +
                ", kisiler=" + kisiler +
                "} " + super.toString();
    }
}
