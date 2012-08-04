package model;

import ProductLine.MessageType;

@SuppressWarnings("serial")
public class Message extends ProductLine.Message {
	
	public Message(){
		
	}
	
	public Message(String sender, String receiver, String subject, String content, MessageType type){
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.content = content;
		this.type = type;
	}	
	
}
