package oop_16_Ocak_Tekrar.example5;

public abstract class Bina implements IBinaIslemleri{

    private String adres;
    private String sehir;
    private String postaKodu;
    private double aylikKira;

    public Bina(String adres, String sehir, String postaKodu, double aylikKira) {
        this.adres = adres;
        this.sehir = sehir;
        this.postaKodu = postaKodu;
        this.aylikKira = aylikKira;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getPostaKodu() {
        return postaKodu;
    }

    public void setPostaKodu(String postaKodu) {
        this.postaKodu = postaKodu;
    }

    public double getAylikKira() {
        return aylikKira;
    }

    public void setAylikKira(double aylikKira) {
        this.aylikKira = aylikKira;
    }

    @Override
    public String toString() {
        return "Bina{" +
                "adres='" + adres + '\'' +
                ", sehir='" + sehir + '\'' +
                ", postaKodu='" + postaKodu + '\'' +
                ", aylikKira=" + aylikKira +
                '}';
    }
}
