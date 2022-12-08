package com.bilgeadam.solid_example.dependency_inversion;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Student {

	static int studentNumber;
	
	public static void main(String[] args) {

		Student.studentNumber++;
		System.out.println(studentNumber);//1.çıktı

		Student student = new Student();
		System.out.println(studentNumber);//2.çıktı

		student.studentNumber++;
		student = new Student();

		studentNumber++;
		System.out.println(studentNumber);//3.çıktı
		
		List<Integer> list= Arrays.asList(1,5,6,7);
		list=list.stream().map(t -> t.intValue()).collect(Collectors.toList());

		for (Integer integer : list) {
		    System.out.println(integer);
		}
		
	}
}


/*Hayvan soyut bir sınıftır ve nesne üretilemez.
Kopek sınıfı Hayvan soyut sınıfından türetilmediği için nesnesi üretilemez.
sesCikar metoduna nesnesi üretilemediği için 'hayvan' gönderilemez. 
Kopek sınıfındaki sesCikar metodu yalnızca Kopek sınıfına aittir. Kopek nesnesi üretilmeden çağırılamaz.


Abstraction açıklaması --> Bir varlık ya da sistemi incelerken, fiziksel, mekansal ve zamansal 
nitelikleri içinden ilgimizi çekmeyen kısımları ayıklamak sureti ile sadece işimize yarayan kısımlara odaklanmak.


1)Bir interface' den başka bir interface oluşturma gibi bir şey OOP de yoktur. Bir interface'in(soyutun) nesnesi üretilemez. 
2)title' ın hata vermesinin sebebi 'movie' nesnesinin MovieRepository tipinde verilmiş olmasıdır. 
Movie movie = new Movie(); --> oluşturulduğunda title' a ulaşılabilir.(aynı class içerisinde tanımlandıysa)


stream().map(t -> t.intValue()) şeklinde olmalıdır.
*/