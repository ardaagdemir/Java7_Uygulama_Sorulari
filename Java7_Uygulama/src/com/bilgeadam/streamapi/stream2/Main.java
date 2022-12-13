package com.bilgeadam.streamapi.stream2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Kisi kisi1 = new Kisi("ahmet", 51, ECinsiyet.ERKEK);
        Kisi kisi2 = new Kisi("mehmet", 18, ECinsiyet.ERKEK);
        Kisi kisi3 = new Kisi("aslı", 25, ECinsiyet.KADIN);
        Kisi kisi4 = new Kisi("zeynep", 32, ECinsiyet.KADIN);
        Kisi kisi5 = new Kisi("ali", 65, ECinsiyet.ERKEK);

        List<Kisi> kisiler = new ArrayList<>();
        kisiler.add(kisi1);
        kisiler.add(kisi2);
        kisiler.add(kisi3);
        kisiler.add(kisi4);
        kisiler.add(kisi5);

        List<Kisi> kadinlar = kisiler.stream().filter(kadin -> kadin.getCinsiyet() == ECinsiyet.KADIN).collect(Collectors.toList());
        System.out.println(kadinlar);

        Set<String> isimYas = kisiler.stream().map(kisi -> kisi.getIsim() + " " + kisi.getYas()).collect(Collectors.toSet());
        //System.out.println(isimYas);
        isimYas.forEach(System.out :: println);

        //İki nesnenin karşılaştırılarak sıralanması --> .sorted(Comparator.comparin())
        //.reversed --> tersten yaz
        List<Kisi> sıralananKisiler = kisiler.stream().sorted(Comparator.comparing(Kisi::getYas)).collect(Collectors.toList());
        //System.out.println(sıralananKisiler);
        sıralananKisiler.forEach(System.out :: println);


    }
}
