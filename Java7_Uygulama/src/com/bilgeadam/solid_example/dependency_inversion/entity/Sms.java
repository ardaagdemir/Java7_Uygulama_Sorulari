package com.bilgeadam.solid_example.dependency_inversion.entity;

import com.bilgeadam.solid_example.dependency_inversion.Message;

public class Sms implements Message {
	
	public static String smsString;
	
	public void sendSms() {
		System.out.println("Sms gönderildi");
	}

	@Override
	public void sendMessage() {
		sendSms();	
	}
	
	public static void smsGonder(String message) {
		
		String gonder = message;
	}
	
}
