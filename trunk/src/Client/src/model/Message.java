package model;

import java.util.Date;

import ProductLine.MessageType;

@SuppressWarnings("serial")
public class Message  extends ProductLine.Message{

	private Date date;
	
	public Message(){
		super();
	}
	
	public Message(String from, String to, String subject, String content,Date date, MessageType type){
		super(from,to,subject,content,type,false);
		this.date = date;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
