package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.services.CustomerServices;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServices customerservices;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> registercustomerHandler(@RequestBody Customer customer){
		//customer.setStatus("regular");
		Customer registercustomer= customerservices.addcustomer(customer);
	
		return new ResponseEntity<Customer>(registercustomer, HttpStatus.ACCEPTED);
	}

	
}
