package com.bilgeadam.memory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //sout --> System.out.println shortcut
    //ctrl+shift+/ --> yorum satırına alma
    public static void main(String[] args) {
        /*int sayi1 = 2;
        System.out.println("Sayi1: " + sayi1);
        int sayi2 = sayi1;
        System.out.println("Sayi2: " + sayi2);
        sayi1 = 5;
        System.out.println(sayi1);
        System.out.println("Sayi2: " + sayi2);*/

        //new'lenen nesnenin ve new'lenmeyen özelliğin referansını eşitleme
        /*Calisan calisan1 = new Calisan();
        Calisan calisan2;
        calisan1.name = "Ayşe";
        System.out.println("Calisan1: " + calisan1.name);
        calisan2 = calisan1;
        System.out.println("Calisan2: " + calisan2.name);

        calisan1.name = "Fatma";
        System.out.println("Güncel Calisan1: " + calisan1.name);
        System.out.println("Güncel Calisan2: " + calisan2.name);*/

        //new' lenen iki nesnenin referanslarını eşitleme
        /*Calisan calisan1 = new Calisan();
        Calisan calisan2 = new Calisan();
        calisan1.name = "Ayşe";
        calisan2.name = "Fatma";

        calisan2 = calisan1;

        System.out.println("Calisan1: " + calisan1.name);
        System.out.println("Calisan2: " + calisan2.name);
        calisan1.name = "Ali";
        System.out.println("Güncel Calisan1: " + calisan1.name);
        System.out.println("Güncel Calisan2: " + calisan2.name);*/


        //birbirinden bağımsız iki nesnenin bellekteki konumları
        Calisan calisan1 = new Calisan();
        Calisan calisan2 = new Calisan();
        calisan1.name = "Ayşe";
        calisan2.name = "Fatma";

        System.out.println("Calisan1: " + calisan1.name);
        //System.out.println("Calisan2: " + calisan2.name);
        /*calisan1.name = "Ali";

        System.out.println("Güncel Calisan1: " + calisan1.name);
        System.out.println("Güncel Calisan2: " + calisan2.name);*/

    }

}
