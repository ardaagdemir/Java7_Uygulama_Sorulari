package oop_16_Ocak_Tekrar.example4;

public class Kaleci extends Oyuncu{

    private int kurtaris;

    public Kaleci(String ad, int formaNo) {
        super(ad, formaNo);
        this.kurtaris = 70 + getRandom().nextInt(30);
    }

    public int getKurtaris() {
        return kurtaris;
    }

    public void setKurtaris(int kurtaris) {
        this.kurtaris = kurtaris;
    }

    @Override
    public String toString() {
        return "Kaleci{" +
                "kurtaris=" + kurtaris +
                "} " + super.toString();
    }
}
