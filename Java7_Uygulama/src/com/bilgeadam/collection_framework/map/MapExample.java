package com.bilgeadam.collection_framework.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		/*Map
		key-value çiftleri ile çalışırlar
		06-Ankara
		key ler uniqe(tektir), aynı key ikinci kez yazılırsa o key yeni değerleriyle set edilmiş olur
		06-Ankara
		06-İstanbul*/
		
		//HashMap
		//Kendi algoritmasına göre sılama yapar. Arka planda girilen key-value çiftlerini hash'ler ve karışık bir sırayla getirir
		//Örneğin 06-Ankara, 34-İstanbul, 01-Adana
		Map<String, Object> hashMap = new HashMap<>(); 
		
		hashMap.put("name", "Ali");
		hashMap.put("surname", "Bilir");
		hashMap.put("yas", "26");
		System.out.println(hashMap);
		
		hashMap.put("name", "Ahmet");
		System.out.println(hashMap);
		
		System.out.println("================================================");
		
		//LinkedHashMap
		//Sıralama algoritmasının önemli olduğu yerlerde kullanılır.
		Map<String, Object> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("name", "Ali");
		linkedHashMap.put("surname", "Bilir");
		linkedHashMap.put("yas", "26");
		linkedHashMap.put("telefon", "0555555");
		linkedHashMap.put("cinsiyet", "Erkek");
		
		System.out.println(linkedHashMap);

	}

}
