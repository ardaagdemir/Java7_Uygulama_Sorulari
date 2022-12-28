package com.bilgeadam.threads.thread2;

public class Kosucu implements Runnable{

    String name;
    int mesafe;
    long sure;

    public Kosucu(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        long baslangic = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " " + ((i*10) + 10) + ". metrede");
        }
        long bitis = System.currentTimeMillis();
        sure = bitis - baslangic;
        System.out.println(name + " adlı kousucu 100 metre mesafeyi " + sure + " milisaniyede koştu");
    }
}
