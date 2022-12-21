package com.masai.exception;

//import org.apache.logging.log4j.message.Message;

public class OrderNotFound extends Exception{

	public OrderNotFound(){
		
	}
	
	public OrderNotFound(String Message ){
		super(Message);
	}
	
}
