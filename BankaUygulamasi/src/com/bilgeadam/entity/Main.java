package com.bilgeadam.entity;

import com.bilgeadam.manager.AccountManager;
import com.bilgeadam.manager.AdminManager;
import com.bilgeadam.manager.UserManager;

public class Main {

	public static void main(String[] args) {
		
		AccountManager accountManager = new AccountManager();
		AccountManager accountManager2 = new AccountManager();
		UserManager userManager = new UserManager();
		AdminManager adminManager = new AdminManager();
		Account account1 = new Account();
		System.out.println(account1);
		User user1 = new User("Ali", "Bilsin", account1);
		
		accountManager.paraYatir(account1, 1000);
		accountManager.paraYatir(account1, 1500);
		accountManager.paraCek(account1, 2000);
		accountManager.hesapBilgileriniGoster(account1);
		
		userManager.otomatikEmailOlustur(user1);
		userManager.bilgileriGoster(user1);
		userManager.krediBasvurusundaBulun(account1, 10000);
		adminManager.krediBasvurusunuOnayla(account1);
		
		accountManager.hesapBilgileriniGoster(account1);
		
		userManager.krediBorcuOdeme(account1, 1000);
		userManager.krediBorcuOdeme(account1, 1000);
		userManager.krediBorcuOdeme(account1, 1000);
		userManager.krediBorcuOdeme(account1, 1000);
		userManager.bilgileriGoster(user1);
		
		userManager.krediBasvurusundaBulun(account1, 10000);
		adminManager.krediBasvurusunuOnayla(account1);
		accountManager.hesapBilgileriniGoster(account1);
		
		adminManager.krediBasvurusunuOnayla(account1);
		
 	}

}
