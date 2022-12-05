package com.bilgeadam.solid_example.dependency_inversion;

public class Email implements Message{
	
	public void sendEmail() {
		System.out.println("Email gönderildi");
	}

	@Override
	public void sendMessage() {
		sendEmail();
	}
	
}
