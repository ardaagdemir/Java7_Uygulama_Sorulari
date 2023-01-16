package oop_16_Ocak_Tekrar.example3;

//interface ve abstract class farkları
//interface'lerde yalnızca 'gövdesiz' metotlar tanımlanabilir
//abstract class'larda property, gövdesiz abstract metot veya gövdeli metotlar tanımlanabilir.

public abstract class Hayvan {
    private String ad;
    private boolean kayitliMi;
    private String dogumTarihi;

    //16:30

    public abstract void bilgileriGoster();
    public abstract void karneOlustur();

    public Hayvan(String ad, boolean kayitliMi, String dogumTarihi) {
        this.ad = ad;
        this.kayitliMi = kayitliMi;
        this.dogumTarihi = dogumTarihi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public boolean isKayitliMi() {
        return kayitliMi;
    }

    public void setKayitliMi(boolean kayitliMi) {
        this.kayitliMi = kayitliMi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    @Override
    public String toString() {
        return "Hayvan{" +
                "ad='" + ad + '\'' +
                ", kayitliMi=" + kayitliMi +
                ", dogumTarihi='" + dogumTarihi + '\'' +
                '}';
    }
}
