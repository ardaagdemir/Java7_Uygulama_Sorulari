package com.bilgeadam.collection_framework.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		
		//Set
		//Benzersiz değerlerin ya da Object'lerin bir yığın altında toplanması istenilen durumlarda kullanılır.
		//Set çalışma sisteminde anahtar ve değer vardır. Burada arka planda anahtarları kendisi oluşturur.
		//Tekrarlanan veriyi tek bir veri şeklinde yazdırır.
		
		//HashSet
		//Kendi algoritmasına göre sıralar
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Ankara");
		hashSet.add("İstanbul");
		hashSet.add("Zonguldak");
		//871264 ---> "Ankara"
		hashSet.add("Zonguldak");
		hashSet.add("Ankara");
		
		System.out.println(hashSet);

		//LinkedHashSet
		//Kullanıcının veya geliştiricinin verdiği sıraya göre sıralar
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("Ankara");
		linkedHashSet.add("İstanbul");
		linkedHashSet.add("Zonguldak");
		System.out.println(linkedHashSet);
	}

}
