package com.masai.services;

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
	public Orders addOrder(Orders order, Integer cid) {

		Customer customer = customerDao.findById(cid).orElseThrow(() -> new RuntimeException("Customer not found!"));

		order.setCustomer(customer);
		
		
		
		
		int size = customer.getOrders().size();
		
		
		if(size<10) {
			order.setDiscount(0);
			customer.setStatus("Regular");
		}
		else if(size>=10 && size<=19) {
			order.setDiscount((order.getOrderamount()*10)/(100));
			customer.setStatus("Gold");
		}
		else if(size>=20) {
			order.setDiscount((order.getOrderamount()*20)/(100));
			customer.setStatus("Platinum");
		}

		
		customer.getOrders().add(order);
		Orders ordered = orderdao.save(order);
		return ordered;

	}

}
