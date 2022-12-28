package com.bilgeadam.threads.thread3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Durak {
    static Queue<Integer> musteriKuyruk = new LinkedList<>();
    List<Taksi> taksiListesi = new ArrayList<>();

    public Durak(){
        this.kuyrukOlustur();
        this.taksiOlustur();
    }

    private void kuyrukOlustur(){
        for (int i = 1; i<=100; i++){
            musteriKuyruk.offer(i);
        }
        System.out.println("Müsteri kuyrugu olustu");
    }

    private void taksiOlustur(){
        for (int i = 1; i<=10; i++){
            taksiListesi.add(new Taksi(i));
        }
        System.out.println("Taksiler olustu");
    }

    public void musteriAl(){
        for (int i=0; i< 10; i++){
            Thread thread = new Thread(taksiListesi.get(i));
            thread.start();
        }
    }
    public static void main(String[] args) {
        Durak durak = new Durak();

        durak.musteriAl();
    }

}
