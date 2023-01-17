package oop_16_Ocak_Tekrar.example5;

public class Main {
    public static void main(String[] args) {

        Apartman apartman1 = new Apartman("Çankaya", "Ankara", "06500", 4000, "Mustafa");

        Kisi kisi1 = new Kisi("Ağdemir", "Arda", "05555555");
        Kisi kisi2 = new Kisi("Bilir", "Ali", "05444444");

        apartman1.insanEkle(kisi1);
        apartman1.insanEkle(kisi2);
        System.out.println("------------------------------------------------------------------------------------------------");
        apartman1.yasayanlariGoster();
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println(apartman1.toString());
        apartman1.kiraOdeme();
        System.out.println("------------------------------------------------------------------------------------------------");
        apartman1.binaBilgileriniGoster();
        System.out.println("------------------------------------------------------------------------------------------------");
        apartman1.iletisimBilgileriniGoster();
        System.out.println("------------------------------------------------------------------------------------------------");
        apartman1.gorevliMaasıOde();
    }
}
