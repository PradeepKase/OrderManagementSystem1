package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.repository.CustomerDao;
@Service
public class CustomerImpl implements CustomerServices{
	
	@Autowired
	private CustomerDao customerdao; 

	@Override
	public Customer addcustomer(Customer customer) {
	Customer addedcustomer= customerdao.save(customer);
//	customer.setStatus("regular");
	return addedcustomer;
	}
//
//	@Override
//	public Order addorder(Order order) {
//		Order addedorder=customerdao.findById()
//	}

	
}
