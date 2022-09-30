package com.entech.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entech.order.model.Customer;
import com.entech.order.model.Order;
import com.entech.order.response.APIErrorResp;
import com.entech.order.response.APIResponse;
import com.entech.order.response.APISuccessResp;
import com.entech.order.service.CustomerService;
import com.entech.order.service.OrderService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/order-api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/create/{customerId}")
	public ResponseEntity<APIResponse> createOrder(@RequestBody Order order,@PathVariable Long customerId) {
		APIResponse resp = null;
		try {
			Customer cust = customerService.findById(customerId);
			if(cust == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order Not created, customer not found",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			order.setCustomer(cust);
			Order ordered = orderService.createOrder(order);
			if(ordered == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order Not created",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"New order created successfully",ordered);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem in Creating customer", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}
	
	@PutMapping("/update/{orderID}")
	public ResponseEntity<APIResponse> updateOrder(@RequestBody Order order,@PathVariable Long orderID) {
		APIResponse resp = null;
		try {
			Order existingOrder = orderService.getOrderById(orderID);
			if(existingOrder!= null) {
				existingOrder.setOrderStatus(order.getOrderStatus());
				existingOrder.setPromiseDueDate(order.getPromiseDueDate());
				existingOrder.setAdvancePaidAmount(order.getAdvancePaidAmount());
				existingOrder.setTotalOrderBillAmount(order.getTotalOrderBillAmount());
			}
			Order ordered = orderService.createOrder(existingOrder);
			if(ordered == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order Not updated",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"Update","Updated order successfully!");
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Update order failed!", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}
	
	@GetMapping("/get-orders/{customerId}")
	public ResponseEntity<APIResponse> getOrderByCustomer(@PathVariable Long customerId) {
		APIResponse resp = null;
		try {
			Customer cust = customerService.findById(customerId);
			if(cust == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order Not created, customer not found",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			
			List<Order> orders = orderService.getOrderByCustomer(cust);
			if(orders == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Orders not found",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"Found Orders",orders);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem getting orders", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}
	
}
