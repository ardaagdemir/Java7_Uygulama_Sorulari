package com.bilgeadam.banka_uygulamasi.manager;

import com.bilgeadam.banka_uygulamasi.entity.Account;

public class AdminManager {

	public void krediBasvurusunuOnayla(Account account) {
		if(account.getKrediBasvurusu()) {
			System.out.println("Başvurunuz onaylanmıştır.");
			account.setBakiye(account.getIstenenKredi() + account.getBakiye());
		}
		else {
			System.out.println("Kredi başvurusu yok");
		}
	}
	
	public void krediBasvurusunuReddet(Account account) {
		if(account.getKrediBasvurusu()) {
			System.out.println("Kredi başvurunuz reddedilmiştir");
			account.setIstenenKredi(0.0);
		}
		else {
			System.out.println("Kredi başvurusu yok.");
		}
	}
}
