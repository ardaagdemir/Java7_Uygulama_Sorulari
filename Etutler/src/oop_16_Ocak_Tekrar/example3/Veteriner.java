package oop_16_Ocak_Tekrar.example3;

import java.util.ArrayList;

public class Veteriner extends Insan{

    private String mezunOlduguOkul;
    private int calismaYili;
    private ArrayList<Musteri> musteriler;

    public Veteriner(String ad, long tcKimlik, String mezunOlduguOkul, int calismaYili) {
        super(ad, tcKimlik);
        this.mezunOlduguOkul = mezunOlduguOkul;
        this.calismaYili = calismaYili;
        this.musteriler = new ArrayList<>();
    }

    public void musteriEkle(Musteri musteri){
        musteriler.add(musteri);
        System.out.println(musteri.getAd() + " isimli müşteri " + this.getAd()  + " isimli veterine eklendi");
    }

    public void musteriListele(){
        for (Musteri item : musteriler){
            item.bilgileriGoster();
        }
    }

    @Override
    public void bilgileriGoster() {
        System.out.println(toString());
    }

    public String getMezunOlduguOkul() {
        return mezunOlduguOkul;
    }

    public void setMezunOlduguOkul(String mezunOlduguOkul) {
        this.mezunOlduguOkul = mezunOlduguOkul;
    }

    public int getCalismaYili() {
        return calismaYili;
    }

    public void setCalismaYili(int calismaYili) {
        this.calismaYili = calismaYili;
    }

    public ArrayList<Musteri> getMusteriler() {
        return musteriler;
    }

    public void setMusteriler(ArrayList<Musteri> musteriler) {
        this.musteriler = musteriler;
    }

    @Override
    public String toString() {
        return super.toString()
                +"Veteriner{" +
                "mezunOlduguOkul='" + mezunOlduguOkul + '\'' +
                ", calismaYili=" + calismaYili +
                ", musteriler=" + musteriler +
                "} ";
    }
}
