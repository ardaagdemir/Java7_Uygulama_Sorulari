package oop_16_Ocak_Tekrar.example4;

public class Main {

    public static void main(String[] args) {


        Takim takim1 = new Takim("Galatasaray Takımı");
        System.out.println(takim1.getTakimIsmi());
        for (Oyuncu item : takim1.getOyuncuList()){
            System.out.println(item);
        }

    }
}
