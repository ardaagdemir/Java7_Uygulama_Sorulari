package oop_16_Ocak_Tekrar.example4;

import java.util.Random;

public abstract class Oyuncu {

    private String ad;
    private int formaNo;
    private int dayaniklilik;
    private int hiz;
    private int pas;
    private int sut;
    private int yetenek;
    private int kararlilik;
    private int dogalForm;
    private int sans;

    private Random random = new Random();

    public Oyuncu(String ad, int formaNo) {
        this.ad = ad;
        this.formaNo = formaNo;
        this.dayaniklilik = 50 + random.nextInt(51);
        this.hiz = 50 + random.nextInt(51);
        this.pas = 50 + random.nextInt(51);
        this.sut = 50 + random.nextInt(51);
        this.yetenek = 50 + random.nextInt(51);
        this.kararlilik = 50 + random.nextInt(51);
        this.dogalForm = 50 + random.nextInt(51);
        this.sans = 50 + random.nextInt(51);
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getFormaNo() {
        return formaNo;
    }

    public void setFormaNo(int formaNo) {
        this.formaNo = formaNo;
    }

    public int getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public int getPas() {
        return pas;
    }

    public void setPas(int pas) {
        this.pas = pas;
    }

    public int getSut() {
        return sut;
    }

    public void setSut(int sut) {
        this.sut = sut;
    }

    public int getYetenek() {
        return yetenek;
    }

    public void setYetenek(int yetenek) {
        this.yetenek = yetenek;
    }

    public int getKararlilik() {
        return kararlilik;
    }

    public void setKararlilik(int kararlilik) {
        this.kararlilik = kararlilik;
    }

    public int getDogalForm() {
        return dogalForm;
    }

    public void setDogalForm(int dogalForm) {
        this.dogalForm = dogalForm;
    }

    public int getSans() {
        return sans;
    }

    public void setSans(int sans) {
        this.sans = sans;
    }


    @Override
    public String toString() {
        return "Oyuncu{" +
                "ad='" + ad + '\'' +
                ", formaNo=" + formaNo +
                ", dayaniklilik=" + dayaniklilik +
                ", hiz=" + hiz +
                ", pas=" + pas +
                ", sut=" + sut +
                ", yetenek=" + yetenek +
                ", kararlilik=" + kararlilik +
                ", dogalForm=" + dogalForm +
                ", sans=" + sans +
                '}';
    }
}
