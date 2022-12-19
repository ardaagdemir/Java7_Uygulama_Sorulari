package com.bilgeadam.solid_example.dependency_inversion.entity;

import com.bilgeadam.solid_example.dependency_inversion.Message;

public class Email implements Message {
	
	public void sendEmail() {
		System.out.println("Email gönderildi");
	}

	@Override
	public void sendMessage() {
		sendEmail();
	}
	
}
