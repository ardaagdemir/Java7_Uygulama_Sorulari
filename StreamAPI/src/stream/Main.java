package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		//sayilar adında Integer tipinde bir Liste oluşturulacka
		//İçerisine 2 basamaklı sayılar eklenecek. (5-6 sayı)
		
		//listede 5 ile bölünen sayılar alınıp yeni bir listeye eklenecek ve liste yazdırılcak (filter)
		//listede 5 ile bölünen kaç sayı var' a bakılacak(filter)
		//listedeki sayıların kendisi ile çarpımları bir listeye eklenecek ve yazdırılacak.(foreach)
		//collect --> ile topluyoduk
		
		List<Integer> sayilar = new ArrayList<>();
        sayilar.add(15);
        sayilar.add(13);
        sayilar.add(20);
        sayilar.add(72);
        sayilar.add(91);
        
        List<Integer> kalansizBolunenler = sayilar.stream().filter(number -> number % 5 == 0).collect(Collectors.toList());
        System.out.println("Kalansız bölünenler : " + kalansizBolunenler);
        
        Long kacTane = sayilar.stream().filter(number -> number % 5 == 0).count();
        System.out.println("5' bölünen sayıların adeti: " + kacTane);
        
        List<Integer> carpim1 = new ArrayList<>(); 
        sayilar.stream().forEach(number -> carpim1.add(number*number));
        System.out.println(carpim1);
        
        List<Integer> carpim2 = sayilar.stream().map(number -> number*number).collect(Collectors.toList());
        System.out.println(carpim2);
        
        
        
	}

}
