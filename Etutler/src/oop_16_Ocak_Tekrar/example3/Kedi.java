package oop_16_Ocak_Tekrar.example3;

public class Kedi extends Hayvan {

    private String tur;
    private String cins;
    private String karne;

    public Kedi(String ad, boolean kayitliMi, String dogumTarihi, String cins) {
        super(ad, kayitliMi, dogumTarihi);
        this.cins = cins;
        this.tur = "Kedi";
    }



    @Override
    public void bilgileriGoster() {
        System.out.println(toString());
    }

    @Override
    public void karneOlustur() {
        setKarne("Cinsi: " + getCins() + ", Türü: " + getTur());
        System.out.println("Karne--> " + getKarne());
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getCins() {
        return cins;
    }

    public void setCins(String cins) {
        this.cins = cins;
    }

    public String getKarne() {
        return karne;
    }

    public void setKarne(String karne) {
        this.karne = karne;
    }

    @Override
    public String toString() {
        return "Kedi{" +
                "Karne='" + karne + '\'' +
                "} " + super.toString();
    }


}
