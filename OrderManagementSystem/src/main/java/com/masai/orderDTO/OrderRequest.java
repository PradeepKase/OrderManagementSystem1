package com.masai.orderDTO;

import com.masai.model.Customer;

public class OrderRequest {

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	public OrderRequest() {
		// TODO Auto-generated constructor stub
	}
	public OrderRequest(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderRequest [customer=" + customer + "]";
	}
	
	
	
	
}
