package com.entech.order.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	private Timestamp orderedOn;
	private Double totalOrderBillAmount;
	private Double advancePaidAmount;
	private Timestamp dueDate;
	private Timestamp promiseDueDate;
	private int totalOrderedItems;
	private Timestamp orderDeliveryDate;
	private String orderStatus;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private List<OrderItem> orderedItems;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Timestamp getOrderedOn() {
		return orderedOn;
	}

	public void setOrderedOn(Timestamp orderedOn) {
		this.orderedOn = orderedOn;
	}

	public Double getTotalOrderBillAmount() {
		return totalOrderBillAmount;
	}

	public void setTotalOrderBillAmount(Double totalOrderBillAmount) {
		this.totalOrderBillAmount = totalOrderBillAmount;
	}

	public Double getAdvancePaidAmount() {
		return advancePaidAmount;
	}

	public void setAdvancePaidAmount(Double advancePaidAmount) {
		this.advancePaidAmount = advancePaidAmount;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getPromiseDueDate() {
		return promiseDueDate;
	}

	public void setPromiseDueDate(Timestamp promiseDueDate) {
		this.promiseDueDate = promiseDueDate;
	}

	public int getTotalOrderedItems() {
		return totalOrderedItems;
	}

	public void setTotalOrderedItems(int totalOrderedItems) {
		this.totalOrderedItems = totalOrderedItems;
	}

	public Timestamp getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	public void setOrderDeliveryDate(Timestamp orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
