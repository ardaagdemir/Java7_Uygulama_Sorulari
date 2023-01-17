package oop_16_Ocak_Tekrar.example4;

public class ForvetOyuncusu extends Oyuncu{

    private int bitiricilik;
    private int ilkDokunus;
    private int kafa;
    private int ozelYetenek;

    public ForvetOyuncusu(String ad, int formaNo) {
        super(ad, formaNo);
        this.bitiricilik = 60 + getRandom().nextInt(40);
        this.ilkDokunus = + getRandom().nextInt(40);
        this.kafa = + getRandom().nextInt(40);
        this.ozelYetenek = + getRandom().nextInt(40);
    }

    public int getBitiricilik() {
        return bitiricilik;
    }

    public void setBitiricilik(int bitiricilik) {
        this.bitiricilik = bitiricilik;
    }

    public int getIlkDokunus() {
        return ilkDokunus;
    }

    public void setIlkDokunus(int ilkDokunus) {
        this.ilkDokunus = ilkDokunus;
    }

    public int getKafa() {
        return kafa;
    }

    public void setKafa(int kafa) {
        this.kafa = kafa;
    }

    public int getOzelYetenek() {
        return ozelYetenek;
    }

    public void setOzelYetenek(int ozelYetenek) {
        this.ozelYetenek = ozelYetenek;
    }

    @Override
    public String toString() {
        return "ForvetOyuncusu{" +
                "bitiricilik=" + bitiricilik +
                ", ilkDokunus=" + ilkDokunus +
                ", kafa=" + kafa +
                ", ozelYetenek=" + ozelYetenek +
                "} " + super.toString();
    }
}
