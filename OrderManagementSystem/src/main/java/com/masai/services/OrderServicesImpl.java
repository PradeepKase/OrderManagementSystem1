package com.masai.services;

import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.repository.CustomerDao;
import com.masai.repository.OrderDao;

@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	private OrderDao orderdao;

	@Autowired
	private CustomerDao customerDao;

	@Override
	public String addOrder(Orders order, Integer cid) {

		Customer customer = customerDao.findById(cid).orElseThrow(() -> new RuntimeException("Customer not found!"));

		order.setCustomer(customer);

		// checking no of orders
		int size = customer.getOrders().size()+1;
		String str = "";

		if (size == 9) {
			str = "You have placed 9 orders with us. Buy one more stuff and you will be promoted to Gold customer and enjoy 10% discounts!\n";
		} else if (size == 19) {
			str = "You have placed 19 orders with us. Buy one more stuff and you will be promoted to Platinum customer and enjoy 20% discounts!\n";
		}

		if (size < 10) {
			order.setDiscount(0);
			customer.setStatus("Regular");
		} else if (size >= 10 && size <= 19) {
			order.setDiscount((order.getOrderamount() * 10) / (100));
			customer.setStatus("Gold");
		} else if (size >= 20) {
			order.setDiscount((order.getOrderamount() * 20) / (100));
			customer.setStatus("Platinum");
		}

		customer.getOrders().add(order);
		Orders ordered = orderdao.save(order);
		// return ordered.toString();
		return str + "order succesfull";
	}

	@Override
	public List<Orders> allorders() {
		List<Orders> orderlist= orderdao.findAll();
		return orderlist;
	}


}
