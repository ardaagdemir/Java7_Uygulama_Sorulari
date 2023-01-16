package oop_16_Ocak_Tekrar.example3;

public class Kopek extends Hayvan{

    private int asiSayisi;
    private String cins;
    private String karne;
    private String tur;

    public Kopek(String ad, boolean kayitliMi, String dogumTarihi, int asiSayisi, String cins) {
        super(ad, kayitliMi, dogumTarihi);
        this.asiSayisi = asiSayisi;
        this.cins = cins;
        this.tur = "Köpek";
    }

    @Override
    public void bilgileriGoster() {
        System.out.println(toString());
    }

    @Override
    public void karneOlustur() {
        setKarne("Cinsi: " + getCins() + ", Türü: " + getTur());
        System.out.println("Karne: " + getKarne());
    }

    public int getAsiSayisi() {
        return asiSayisi;
    }

    public void setAsiSayisi(int asiSayisi) {
        this.asiSayisi = asiSayisi;
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

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    @Override
    public String toString() {
        return "Kopek{" +
                "asiSayisi=" + asiSayisi +
                ", cins='" + cins + '\'' +
                ", karne='" + karne + '\'' +
                "} " + super.toString();
    }


}
