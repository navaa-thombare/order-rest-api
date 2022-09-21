package com.entech.order.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order_item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long orderItemId;
	
	private String item;
	private Double height;
	private Double waist;
	private Double hip;
	private Double hipHeight;
	private Double thigh;
	private Double knee;
	private Double bottom;
	private Double shoulder;
	private Double chest;
	private Double arm;
	private Double front;
	private Double stomach;
	private Double collor;
	private Double handCough;
	private String specialInstruction;
	private Double cost;
	private Timestamp orderedOnDate;
	private Timestamp deliveryDate;
	private String status;
	private Timestamp updatedOnDate;
	private String updatedBy;
	private String workerName;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Double getHip() {
		return hip;
	}

	public void setHip(Double hip) {
		this.hip = hip;
	}

	public Double getHipHeight() {
		return hipHeight;
	}

	public void setHipHeight(Double hipHeight) {
		this.hipHeight = hipHeight;
	}

	public Double getThigh() {
		return thigh;
	}

	public void setThigh(Double thigh) {
		this.thigh = thigh;
	}

	public Double getKnee() {
		return knee;
	}

	public void setKnee(Double knee) {
		this.knee = knee;
	}

	public Double getBottom() {
		return bottom;
	}

	public void setBottom(Double bottom) {
		this.bottom = bottom;
	}

	public Double getShoulder() {
		return shoulder;
	}

	public void setShoulder(Double shoulder) {
		this.shoulder = shoulder;
	}

	public Double getChest() {
		return chest;
	}

	public void setChest(Double chest) {
		this.chest = chest;
	}

	public Double getArm() {
		return arm;
	}

	public void setArm(Double arm) {
		this.arm = arm;
	}

	public Double getFront() {
		return front;
	}

	public void setFront(Double front) {
		this.front = front;
	}

	public Double getStomach() {
		return stomach;
	}

	public void setStomach(Double stomach) {
		this.stomach = stomach;
	}

	public Double getCollor() {
		return collor;
	}

	public void setCollor(Double collor) {
		this.collor = collor;
	}

	public Double getHandCough() {
		return handCough;
	}

	public void setHandCough(Double handCough) {
		this.handCough = handCough;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Timestamp getOrderedOnDate() {
		return orderedOnDate;
	}

	public void setOrderedOnDate(Timestamp orderedOnDate) {
		this.orderedOnDate = orderedOnDate;
	}

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUpdatedOnDate() {
		return updatedOnDate;
	}

	public void setUpdatedOnDate(Timestamp updatedOnDate) {
		this.updatedOnDate = updatedOnDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
