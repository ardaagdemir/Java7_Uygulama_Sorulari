package oop_16_Ocak_Tekrar.example4;

public class OrtaSahaOyuncusu extends Oyuncu{

    private int uzunTop;
    private int ilkDokunus;
    private int topSurme;
    private int uretkenlik;
    private int ozelYetenek;

    public OrtaSahaOyuncusu(String ad, int formaNo) {
        super(ad, formaNo);
        this.uzunTop = 60 + getRandom().nextInt(40);
        this.ilkDokunus = 60 + getRandom().nextInt(40);
        this.topSurme = 60 + getRandom().nextInt(40);
        this.uretkenlik = 60 + getRandom().nextInt(40);
        this.ozelYetenek = 60 + getRandom().nextInt(40);
    }

    public int getUzunTop() {
        return uzunTop;
    }

    public void setUzunTop(int uzunTop) {
        this.uzunTop = uzunTop;
    }

    public int getIlkDokunus() {
        return ilkDokunus;
    }

    public void setIlkDokunus(int ilkDokunus) {
        this.ilkDokunus = ilkDokunus;
    }

    public int getTopSurme() {
        return topSurme;
    }

    public void setTopSurme(int topSurme) {
        this.topSurme = topSurme;
    }

    public int getUretkenlik() {
        return uretkenlik;
    }

    public void setUretkenlik(int uretkenlik) {
        this.uretkenlik = uretkenlik;
    }

    public int getOzelYetenek() {
        return ozelYetenek;
    }

    public void setOzelYetenek(int ozelYetenek) {
        this.ozelYetenek = ozelYetenek;
    }

    @Override
    public String toString() {
        return "OrtaSahaOyuncusu{" +
                "uzunTop=" + uzunTop +
                ", ilkDokunus=" + ilkDokunus +
                ", topSurme=" + topSurme +
                ", uretkenlik=" + uretkenlik +
                ", ozelYetenek=" + ozelYetenek +
                "} " + super.toString();
    }
}
