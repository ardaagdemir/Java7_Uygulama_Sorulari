package oop_16_Ocak_Tekrar.example3;

public class Main {

    public static void main(String[] args) {

        Kedi kedi1 = new Kedi("Boncuk", true, "2018", "Tekir");
        Kedi kedi2 = new Kedi("Şanslı", false, "2019", "Van Kedisi");

        Kopek kopek1 = new Kopek("Fino", true, "2019", 5,"Sibirya Kurdu");

        kedi1.karneOlustur();
        kedi1.bilgileriGoster();
        System.out.println("--------------------------------------------------------------------------------------------");
        kedi2.karneOlustur();
        kedi2.bilgileriGoster();
        System.out.println("--------------------------------------------------------------------------------------------");
        kopek1.karneOlustur();
        kopek1.bilgileriGoster();
        System.out.println("--------------------------------------------------------------------------------------------");


        Musteri musteri1 = new Musteri("Ahmet", 545678495123l, "Çankaya");
        Musteri musteri2 = new Musteri("Mehmet", 12312412514l, "Yenimahalle");

        musteri1.hayvanEkle(kedi1);
        musteri1.hayvanEkle(kopek1);
        System.out.println("--------------------------------------------------------------------------------------------");
        musteri2.hayvanEkle(kedi2);


        Veteriner veteriner1 = new Veteriner("Emre", 484576586548l, "Ankara Veterinerlik", 5);
        veteriner1.musteriEkle(musteri1);
        System.out.println("--------------------------------------------------------------------------------------------");
        veteriner1.musteriListele();
        System.out.println("--------------------------------------------------------------------------------------------");
        veteriner1.bilgileriGoster();
    }
}
