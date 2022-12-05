package cevap_3;

public abstract class MemeliHayvan extends Hayvan{

	public MemeliHayvan(String ad, int kilo, int uzunluk) {
		super(ad, kilo, uzunluk);
	}
	
	public abstract String yuru();
}
