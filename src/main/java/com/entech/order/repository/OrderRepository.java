package com.entech.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entech.order.model.Customer;
import com.entech.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	public List<Order> findByCustomer(Customer cust);
	
	

}
