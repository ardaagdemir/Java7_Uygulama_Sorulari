package com.bilgeadam.threads.thread2;

public class YuzMetreKosusu {

    //100 metre koşusu yalan iki atlet yarışacak
    //Her 10 metrede bir atletlerin durumunu göstereceğiz
    //Ne kadar sürede yarışı bitirdiklerini göreceğiz
    //Başlangıç ve bitiş süreleri

    public static void main(String[] args) {

        Kosucu kosucu1 = new Kosucu("Emre");
        Kosucu kosucu2 = new Kosucu("Berke");

        Thread thread1 = new Thread(kosucu1);
        Thread thread2 = new Thread(kosucu2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        if (kosucu1.sure > kosucu2.sure){
            System.out.println(kosucu2.name + " Yarisi kazanmistir");
        }else{
            System.out.println(kosucu1.name + " yarisi kazanmistir");
        }

    }
}
