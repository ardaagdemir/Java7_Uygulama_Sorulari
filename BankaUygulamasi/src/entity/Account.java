package entity;

import java.util.Random;

public class Account {

	private String hesapNo;
	private double bakiye;
	private boolean krediBasvurusu;
	private double istenenKredi;
	
	public Account() {
		Random random = new Random();
		int rastgeleSayi = random.nextInt(10000000);
		String rastgeleHesapNumarası = String.valueOf(rastgeleSayi);
		this.hesapNo = rastgeleHesapNumarası;
	}
	
	public Account(String hesapNo) {
		this.hesapNo = hesapNo;
	}
	
	public String getHesapNo() {
		return hesapNo;
	}
	public void setHesapNo(String hesapNo) {
		this.hesapNo = hesapNo;
	}
	public double getBakiye() {
		return bakiye;
	}
	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}
	public boolean getKrediBasvurusu() {
		return krediBasvurusu;
	}
	public void setKrediBasvurusu(boolean krediBasvurusu) {
		this.krediBasvurusu = krediBasvurusu;
	}
	public double getIstenenKredi() {
		return istenenKredi;
	}
	public void setIstenenKredi(double istenenKredi) {
		this.istenenKredi = istenenKredi;
	}
	
	@Override
	public String toString() {
		return "Account [hesapNo=" + hesapNo + ", bakiye=" + bakiye + ", krediBasvurusu=" + krediBasvurusu
				+ ", istenenKredi=" + istenenKredi + "]";
	}
}
