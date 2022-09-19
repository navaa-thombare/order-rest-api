package com.entech.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entech.order.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByMobileNo(String mobileNo);
}
