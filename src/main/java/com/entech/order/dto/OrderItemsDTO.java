package com.entech.order.dto;

import java.util.ArrayList;
import java.util.List;

import com.entech.order.model.OrderItem;

public class OrderItemsDTO {
	
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	

}
