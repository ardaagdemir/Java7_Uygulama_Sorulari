package com.bilgeadam.collection_framework.arraylist;

import java.util.ArrayList;

public class ArrayListExample2 {

	public static void main(String[] args) {
		
		//Bazı şehirlerin olduğu bir liste olsun
		//Bu listede ilk iki harfi 'an' ile başlayanlar var ise bu şehir 'xxx' ile değişsin
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Ankara");
		arrayList.add("Bursa");
		arrayList.add("İstanbul");
		arrayList.add("Trabzon");
		arrayList.add("Zonguldak");
		arrayList.add("Antalya");
		
		for(int i=0; i<arrayList.size(); i++) {
			if (arrayList.get(i).toLowerCase().startsWith("an")) {
				arrayList.set(i, "xxx");
			}
		}
		for(String array : arrayList) {
			System.out.println(array);
		}
	}
}
