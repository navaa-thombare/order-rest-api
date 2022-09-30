package com.entech.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entech.order.model.Order;
import com.entech.order.model.OrderItem;
import com.entech.order.repository.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public OrderItem createOrderItem(OrderItem orderItem) {
		return null;
	}
	
	public String createMultipleOrderItems(List<OrderItem> items) {
		List<OrderItem> itms = orderItemRepository.saveAll(items);
		if(itms.size() > 0)
			return "Items created successfully";
		return "No items created";
	}
	
	public void getOrderItemById() {
		
	}
	
	public List<OrderItem> getOrderItemsByOrderId(Order order) {
		return orderItemRepository.findByOrder(order);
	}
	
	
}
