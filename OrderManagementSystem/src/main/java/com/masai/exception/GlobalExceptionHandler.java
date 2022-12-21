package com.masai.exception;

import java.time.LocalDateTime;

//import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(OrderNotFound.class)
	public ResponseEntity<MyerrorDetails> MyexceptionHandler(OrderNotFound ie,WebRequest wr) {
	MyerrorDetails myerror=new MyerrorDetails();
	myerror.setDetails(wr.getDescription(false));
	myerror.setMessage(ie.getMessage());
	myerror.setTimestamp(LocalDateTime.now());
	return new ResponseEntity<MyerrorDetails>(myerror,HttpStatus.BAD_REQUEST);
	
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyerrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyerrorDetails err=new MyerrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails("validation error");
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyerrorDetails> myExceptionHandler(Exception e,WebRequest req) {
		MyerrorDetails err=new MyerrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(e.getMessage());
		err.setMessage(req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}



}
