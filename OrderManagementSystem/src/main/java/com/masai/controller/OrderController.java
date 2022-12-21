package com.masai.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.OrderNotFound;
import com.masai.model.Orders;
import com.masai.services.OrderServices;

@RestController
public class OrderController {


	@Autowired
	private OrderServices orderServices;

	@PostMapping("/addorders/{cid}")
	public ResponseEntity<String> registerOrderHandler(@RequestBody Orders orderrequest, @PathVariable("cid") Integer cid) throws OrderNotFound {

		String registerorder = orderServices.addOrder(orderrequest, cid);

		return new ResponseEntity<String>(registerorder, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/")
	public String wlcome() {
		return "welcome to order management system";
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Orders>> getAllOrdersHandler(){
		List<Orders> listofallorders= orderServices.allorders();
		return new  ResponseEntity<List<Orders>>(listofallorders,HttpStatus.OK);
	}
	
}