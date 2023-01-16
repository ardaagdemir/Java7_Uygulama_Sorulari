package oop_16_Ocak_Tekrar.example3;

import java.util.ArrayList;

public class Musteri extends Insan{

    private String adres;
    private ArrayList<Hayvan> hayvanListesi;

    public Musteri(String ad, long tcKimlik, String adres) {
        super(ad, tcKimlik);
        this.adres = adres;
        hayvanListesi = new ArrayList<>();
    }

    public void hayvanEkle(Hayvan hayvan){
        hayvanListesi.add(hayvan);
        System.out.println(hayvan.getAd() + " isimli hayvan " + this.getAd() +" isimli müşteriye eklendi");
    }

    @Override
    public void bilgileriGoster() {
        System.out.println(toString());
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public ArrayList<Hayvan> getHayvanListesi() {
        return hayvanListesi;
    }

    public void setHayvanListesi(ArrayList<Hayvan> hayvanListesi) {
        this.hayvanListesi = hayvanListesi;
    }

    @Override
    public String toString() {
        return super.toString()
                + " Musteri{"
                + "adres='" + adres + '\'' +
                ", hayvanListesi=" + hayvanListesi +
                "} ";
    }
}
