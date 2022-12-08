package com.bilgeadam.collection_framework.map;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample2 {

	public static void main(String[] args) {
		
		//character ve int tutan bir hashmap oluşturalım
		//kullanıcıdan bir kelime alalım
		//ve girilen kelimede hangi harften kaç tane var onu yazdıralım
		
		String kelime = "selamm";
		Map<Character, Integer> hMap = new LinkedHashMap<>();
		
		for(int i = 0; i < kelime.length(); i++) {
			char harf = kelime.charAt(i);
			
			if (hMap.containsKey(harf)) {
				hMap.put(harf, hMap.get(harf)+1);
			}else {
				hMap.put(harf, 1);
			}
		}
		System.out.println(hMap);
		
	}

}
