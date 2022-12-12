package com.bilgeadam.stream2;

public class Kisi {
    private String isim;
    private int yas;
    private ECinsiyet cinsiyet;

    public Kisi(String isim, int yas, ECinsiyet cinsiyet) {
        this.isim = isim;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public ECinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(ECinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "isim='" + isim + '\'' +
                ", yas=" + yas +
                ", cinsiyet=" + cinsiyet +
                '}';
    }
}
