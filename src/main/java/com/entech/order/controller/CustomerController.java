package com.entech.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entech.order.dto.CustomerDTO;
import com.entech.order.model.Customer;
import com.entech.order.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/order-api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id){
		return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer cust = customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		
	}
	
	@PostMapping("/find")
	public ResponseEntity<Customer> findCustomerByMobileNumber(@RequestBody CustomerDTO custDTO){
		Customer cust = customerService.findCustomerByMobileNumber(custDTO);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}

}
