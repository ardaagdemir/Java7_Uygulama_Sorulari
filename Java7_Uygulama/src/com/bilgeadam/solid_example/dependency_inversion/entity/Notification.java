package com.bilgeadam.solid_example.dependency_inversion.entity;


import com.bilgeadam.solid_example.dependency_inversion.Message;

public class Notification {

	private Message messages;
	
	public Notification(Message messages) {
		this.messages = messages;
	}
	
	
	public void sender() {
		messages.sendMessage();
	}
	
	
//	public Email email = new Email();
//	public Sms sms = new Sms();
//	
//	public void sender() {
//		email.sendEmail();
//		sms.sendSms();
//	}
}
