package com.bilgeadam.maraton1_uygulama.cevap_3;

public class Yılan extends Surungen{

	public Yılan(String ad, int kilo, int uzunluk) {
		super(ad, kilo, uzunluk);
		this.tehlikeliMi = true;
	}

	@Override
	public String surun() {
		return " sürünüyor..";
		
	}

	@Override
	public String sesCikar() {
		return "tıslama sesi çıkarıyor...";
	}

}
