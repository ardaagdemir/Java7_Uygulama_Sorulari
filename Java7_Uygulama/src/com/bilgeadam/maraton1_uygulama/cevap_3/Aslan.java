package com.bilgeadam.maraton1_uygulama.cevap_3;

public class Aslan extends MemeliHayvan {

	public Aslan(String ad, int kilo, int uzunluk) {
		super(ad, kilo, uzunluk);
		this.tehlikeliMi = true;
	}

	@Override
	public String yuru() {
		return " yürüyor...";
	}

	@Override
	public String sesCikar() {
		return "kükrüyor..";
	}

}
