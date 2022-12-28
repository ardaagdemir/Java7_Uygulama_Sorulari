package com.bilgeadam.threads.thread1;

public class Calisan extends Thread{

    private String name;

    public Calisan(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i =0; i< 10; i++){
            System.out.println(name + " calisiyor." + (i+1));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    //run metodu 10 kere dönsün ve her dönüşte çalışanın ismini ve 'çalışıyor'
    //1 sn geciklemeli
    //2 thread çalışsın
}
