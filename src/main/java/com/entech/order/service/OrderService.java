package com.entech.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entech.order.model.Customer;
import com.entech.order.model.Order;
import com.entech.order.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	public List<Order> getOrderByCustomer(Customer cust) {
		
		return orderRepository.findByCustomer(cust);
	}
	
	public Order getOrderById(long id) {
		Optional<Order> optOrder = orderRepository.findById(id);
		if(optOrder.isPresent()) {
			return optOrder.get();
		}
		return null;
	}

}
