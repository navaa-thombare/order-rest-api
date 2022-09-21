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
import com.entech.order.response.APIErrorResp;
import com.entech.order.response.APIResponse;
import com.entech.order.response.APISuccessResp;
import com.entech.order.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/order-api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getCustomerByID(@PathVariable("id") long id){
		APIResponse resp = null;
		try {
			Customer cust = customerService.getCustomerById(id);
			if(cust == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"No Customer available",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"Get Customer by ID",cust);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem in getting customer", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<APIResponse> createCustomer(@RequestBody Customer customer){
		APIResponse resp = null;
		try {
			Customer cust = customerService.createCustomer(customer);
			if(cust == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Customer Not created",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"New customer created successfully",cust);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem in Creating customer", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
		
	}
	
	@PostMapping("/find")
	public ResponseEntity<APIResponse> findCustomerByMobileNumber(@RequestBody CustomerDTO custDTO){
		APIResponse resp = null;
		try {
			Customer cust = customerService.findCustomerByMobileNumber(custDTO);
			if(cust == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Customer not found",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"Get customer by Mobile Number",cust);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem in getting customer", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}

}
