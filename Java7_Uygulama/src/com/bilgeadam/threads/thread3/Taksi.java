package com.bilgeadam.threads.thread3;

import java.util.ArrayList;
import java.util.List;

public class Taksi implements Runnable{

    // * Durağımızda toplam 10 adet taksi olsun ve durak onunde 50 kişilik
    // * bir müşteri kuygrugu(queue) olsun bu musterilerimiz için sınıf yaratmayalım
    // * bir int bir id değeri olarak tutalım
    // * 10 adet taksimiz hızlarına göre kuyruktan sırayla musteri alacaklardır

    //Queue --> kuyruk demektir. ilk giren ilk çıkar

    int id;
    long musteriBirakmaSuresi;
    List<Integer> musteriIdleri = new ArrayList<>();
    long musteriSayisi;

    public Taksi(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        //taksiler kuyruk bitene kadar müşteri alacak
        //musteriId leri listeden almamız gerekecek. Sebebi ise hangi müşterinin taksiye bindiğini anlayabilmek

        while(!Durak.musteriKuyruk.isEmpty()){
            //poll() --> Kuyruktaki eleman kullanıldığında(tüketildiğinde) bu elemanı sırasına göre kuyruktan çıkarır.
            int musteriNo = Durak.musteriKuyruk.poll();
            musteriIdleri.add(musteriNo);
            System.out.println(id + ". Taksi " + musteriIdleri.size() + ".musteriyi aldı." + musteriNo);
            try {
                Thread.sleep(musteriBirakmaSuresi);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        musteriSayisi = musteriIdleri.size();
        System.out.println(id + ". taksi toplam "  + musteriSayisi + " musteri aldi.");
    }
}
