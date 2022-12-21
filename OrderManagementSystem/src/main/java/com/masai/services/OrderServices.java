package com.masai.services;

import java.util.List;

import javax.persistence.criteria.Order;

import com.masai.exception.OrderNotFound;
import com.masai.model.Orders;

public interface OrderServices {

	public String addOrder(Orders order, Integer cid)throws OrderNotFound;
	
	public List<Orders> allorders();
}
