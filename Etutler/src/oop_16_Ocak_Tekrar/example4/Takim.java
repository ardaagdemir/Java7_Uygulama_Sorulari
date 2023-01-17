package oop_16_Ocak_Tekrar.example4;

import java.util.ArrayList;
import java.util.List;

public class Takim {

    private String takimIsmi;
    private Kaleci kaleci;
    private List<Oyuncu> oyuncuList;

    public Takim(String takimIsmi) {
        oyuncuList = new ArrayList<>();
        this.takimIsmi = takimIsmi;
        defansOlustur();
        ortaSahaOlustur();
        forvetOlustur();
        kaleciOlustur();
    }

    //12:05
    public void defansOlustur(){
        for (int i = 1; i<=4; i++){
            DefansOyuncusu defansOyuncusu = new DefansOyuncusu("Defans" + i, i+1);
            oyuncuList.add(defansOyuncusu);
        }
    }

    public void ortaSahaOlustur(){
        for (int i = 1; i<=4; i++){
            OrtaSahaOyuncusu ortaSahaOyuncusu = new OrtaSahaOyuncusu("Ortasaha" + i, i+5);
            oyuncuList.add(ortaSahaOyuncusu);
        }
    }

    public void forvetOlustur(){
        for (int i = 1; i<=2; i++){
            ForvetOyuncusu forvetOyuncusu = new ForvetOyuncusu("Forvet" + i, i+9);
            oyuncuList.add(forvetOyuncusu);
        }
    }

    public Kaleci kaleciOlustur(){
        kaleci = new Kaleci("Kaleci 1", 1);
        oyuncuList.add(kaleci);
        return kaleci;
    }

    public String getTakimIsmi() {
        return takimIsmi;
    }

    public void setTakimIsmi(String takimIsmi) {
        this.takimIsmi = takimIsmi;
    }

    public Kaleci getKaleci() {
        return kaleci;
    }

    public void setKaleci(Kaleci kaleci) {
        this.kaleci = kaleci;
    }

    public List<Oyuncu> getOyuncuList() {
        return oyuncuList;
    }

    public void setOyuncuList(List<Oyuncu> oyuncuList) {
        this.oyuncuList = oyuncuList;
    }

    @Override
    public String toString() {
        return "Takim{" +
                "takimIsmi='" + takimIsmi + '\'' +
                ", kaleci=" + kaleci +
                ", oyuncuList=" + oyuncuList +
                '}';
    }
}
