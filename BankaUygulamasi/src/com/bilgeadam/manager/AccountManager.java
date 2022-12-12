package com.bilgeadam.manager;

import com.bilgeadam.entity.Account;

public class AccountManager {

    public void paraYatir(Account account, double miktar) {

        if (miktar <= 10000) {
            account.setBakiye(account.getBakiye() + miktar);
            System.out.println("Yatırılan miktar: " + miktar + ", Güncel Bakiye: " + account.getBakiye());
        } else {
            System.out.println("10000TL' den fazla yatıramazsınız.");
        }
    }

    public void paraCek(Account account, double miktar) {
        if (miktar > account.getBakiye()) {
            System.out.println("Çekmek istediğiniz tutar için bakiyeniz yetersiz.");
        } else {
            account.setBakiye(account.getBakiye() - miktar);
            System.out.println("Çektiğiniz miktar: " + miktar + ", Güncel Bakiye: " + account.getBakiye());
        }
    }

    public void hesapBilgileriniGoster(Account account) {
        System.out.println("Hesap numarası: " + account.getHesapNo() + ", Güncel Bakiye: " + account.getBakiye());
    }

}
