package cevap_3;

public abstract class Hayvan {
	public String ad;
	public int kilo;
	public int uzunluk;
	public boolean tehlikeliMi;
	
	
	public Hayvan(String ad, int kilo, int uzunluk) {
		super();
		this.ad = ad;
		this.kilo = kilo;
		this.uzunluk = uzunluk;
	}

	public abstract String sesCikar();

	@Override
	public String toString() {
		return "Hayvan [ad=" + ad + ", kilo=" + kilo + ", uzunluk=" + uzunluk + ", tehlikeliMi=" + tehlikeliMi + "]";
	}
}
