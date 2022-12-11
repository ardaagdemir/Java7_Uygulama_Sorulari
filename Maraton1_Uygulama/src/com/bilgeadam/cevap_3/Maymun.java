package com.bilgeadam.cevap_3;

public class Maymun extends MemeliHayvan{

	public Maymun(String ad, int kilo, int uzunluk) {
		super(ad, kilo, uzunluk);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String yuru() {
		return " koşuyor..";
	}

	@Override
	public String sesCikar() {
		return "konuşuyor";
	}
}
