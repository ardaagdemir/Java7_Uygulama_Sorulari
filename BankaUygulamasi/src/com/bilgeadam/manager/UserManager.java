package com.bilgeadam.manager;

import com.bilgeadam.entity.Account;
import com.bilgeadam.entity.User;

public class UserManager {
	
	String emailFormat = "@xbanka.com";
	
	public void otomatikEmailOlustur(User user) {
		//email kişinin adından ve soyadından
		
		String otomatikOlusanEmail = user.getName().toLowerCase() + "." + user.getSurname().toLowerCase() + emailFormat;
		user.setEmail(otomatikOlusanEmail);
		System.out.println(user.getEmail());
	}
	
	public void bilgileriGoster(User user) {
		System.out.println("İsim: " + user.getName() + " Surname: " + user.getSurname() + " HesapNo: "
				+ user.getAccount().getHesapNo() + " Email: " + user.getEmail() + " Hesap Bakiyeniz: "
				+ user.getAccount().getBakiye() + " Kalan kredi Borcunuz " + user.getAccount().getIstenenKredi()
		);
	}
	
	public void krediBasvurusundaBulun(Account account, int para) {
		account.setKrediBasvurusu(true);
		account.setIstenenKredi(para);
		System.out.println("Kredi başvurusu miktarı: " + account.getIstenenKredi());
		System.out.println("Lütfen onay bekleyin.");
	}
	
	public void krediBorcuOdeme(Account account, double taksit) {
		if(account.getIstenenKredi() == 0) {
			System.out.println("Kredi borcunuz yoktur");
		}
		else if(account.getIstenenKredi() < 0) {
			System.out.println("Kredi borcu ödenmiştir.");
		}
		else {
			account.setIstenenKredi(account.getIstenenKredi() - taksit);
			System.out.println("Ödenen miktar: " + taksit + ", Kalan Borç: " + account.getIstenenKredi());
		}
	}
}
