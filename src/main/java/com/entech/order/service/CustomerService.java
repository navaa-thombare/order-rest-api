package com.entech.order.service;

import java.util.Optional;

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
		Optional<Customer> opCust = customerRepository.findById(id);
		if(opCust.isPresent()) {
			return opCust.get();
		}else {
			return null;
		}
	}

	public Customer createCustomer(Customer customer) {
		System.out.println(customer.getFirstName());
		return customerRepository.save(customer);
	}

	public Customer findCustomerByMobileNumber(CustomerDTO custDTO) {
		String mobNo = custDTO.getMobileNo();
		Optional<Customer> opCust = customerRepository.findByMobileNo(mobNo);
		if(opCust.isPresent()) {
			return opCust.get();
		}else {
			return null;
		}
	}

	public Customer findById(Long customerId) {
		
		return customerRepository.findById(customerId).isPresent()? customerRepository.findById(customerId).get():null;
	}
}
