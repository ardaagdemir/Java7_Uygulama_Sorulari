package oop_16_Ocak_Tekrar.example4;

public class DefansOyuncusu extends Oyuncu{

    private int pozisyonAlma;
    private int kafa;
    private int sicrama;

    public DefansOyuncusu(String ad, int formaNo) {
        super(ad, formaNo);
        this.pozisyonAlma = 60 + getRandom().nextInt(40);
        this.kafa = 60 + getRandom().nextInt(40);
        this.sicrama = 60 + getRandom().nextInt(40);
    }

    public int getPozisyonAlma() {
        return pozisyonAlma;
    }

    public void setPozisyonAlma(int pozisyonAlma) {
        this.pozisyonAlma = pozisyonAlma;
    }

    public int getKafa() {
        return kafa;
    }

    public void setKafa(int kafa) {
        this.kafa = kafa;
    }

    public int getSicrama() {
        return sicrama;
    }

    public void setSicrama(int sicrama) {
        this.sicrama = sicrama;
    }

    @Override
    public String toString() {
        return "DefansOyuncusu{" +
                "pozisyonAlma=" + pozisyonAlma +
                ", kafa=" + kafa +
                ", sicrama=" + sicrama +
                "} " + super.toString();
    }
}
