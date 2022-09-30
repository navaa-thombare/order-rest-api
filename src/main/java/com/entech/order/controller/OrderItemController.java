package com.entech.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entech.order.dto.OrderItemsDTO;
import com.entech.order.model.Customer;
import com.entech.order.model.Order;
import com.entech.order.model.OrderItem;
import com.entech.order.response.APIErrorResp;
import com.entech.order.response.APIResponse;
import com.entech.order.response.APISuccessResp;
import com.entech.order.service.OrderItemService;
import com.entech.order.service.OrderService;

@RestController
@RequestMapping("/order-api/order-item")
public class OrderItemController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@SuppressWarnings("unused")
	@PostMapping("/create-order-item/{orderId}")
	public ResponseEntity<APIResponse> createOrderItem(@RequestBody OrderItem orderItem,@PathVariable Long orderId) {
		APIResponse resp = null;
		try {
			Order order = orderService.getOrderById(orderId);
			if(order == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order item Not created, order not found",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			orderItem.setOrder(order);
			OrderItem orderedItem = orderItemService.createOrderItem(orderItem);
			if(orderedItem == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order Not created",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"New order item created successfully",orderedItem);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem in Creating Order Item", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/get-order-items/{orderId}")
	public ResponseEntity<APIResponse> getOrderItemsByOrderId(@PathVariable Long orderId) {
		APIResponse resp = null;
		try {
			Order order = orderService.getOrderById(orderId);
			if(order == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order not found!",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			
			List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(order);
			if(orderItems == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"OrderItems not found",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			resp = new APISuccessResp(HttpStatus.OK,"Found Orders",orderItems);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem getting orders", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/create-order-items/{orderId}")
	public ResponseEntity<APIResponse> createOrderItems(@RequestBody OrderItemsDTO orderItemsDTO,@PathVariable Long orderId) {
		APIResponse resp = null;
		try {
			Order order = orderService.getOrderById(orderId);
			if(order == null) {
				resp = new APIErrorResp(HttpStatus.EXPECTATION_FAILED,"Order items Not created, order not found",1);
				return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
			}
			List<OrderItem> items = new ArrayList<OrderItem>();
			for (OrderItem orderItem : orderItemsDTO.getItems()) {
				orderItem.setOrder(order);
				items.add(orderItem);
			}
			String success = orderItemService.createMultipleOrderItems(items);
			resp = new APISuccessResp(HttpStatus.OK,success,items);
		}catch(Exception e) {
		 resp = new APIErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, "Problem in Creating Order Items", 1);
		}
		return new ResponseEntity<APIResponse>(resp,HttpStatus.OK);
	}

}
