package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Orders;
import com.masai.services.OrderServices;

@RestController
public class OrderController {
//	@Autowired
//	private CustomerDao customerdao;

	@Autowired
	private OrderServices orderservices;

	@PostMapping("/addorders/{cid}")
	public ResponseEntity<Orders> registerOrderHandler(@RequestBody Orders orderrequest, @PathVariable("cid") Integer cid) {

		Orders registerorder = orderservices.addOrder(orderrequest, cid);

		return new ResponseEntity<Orders>(registerorder, HttpStatus.ACCEPTED);
	}

//	@GetMapping("/getallcustomer")
//	public List<Customer> getallcustomer() {
//		return customerdao.findAll();
//	}
}
