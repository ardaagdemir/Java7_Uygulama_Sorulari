package oop_16_Ocak_Tekrar.example3;

public abstract class Insan {

    private String ad;
    private long tcKimlik;

    public Insan(String ad, long tcKimlik) {
        this.ad = ad;
        this.tcKimlik = tcKimlik;
    }

    public abstract void bilgileriGoster();

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public long getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(long tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    @Override
    public String toString() {
        return "Insan{" +
                "ad='" + ad + '\'' +
                ", tcKimlik=" + tcKimlik +
                '}';
    }
}
