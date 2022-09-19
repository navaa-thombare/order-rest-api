package com.entech.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entech.order.dto.CustomerDTO;
import com.entech.order.model.Customer;
import com.entech.order.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}

	public Customer createCustomer(Customer customer) {
		System.out.println(customer.getFirstName());
		return customerRepository.save(customer);
	}

	public Customer findCustomerByMobileNumber(CustomerDTO custDTO) {
		return customerRepository.findByMobileNo(custDTO.getMobileNo()).get(0);
	}
}
