package com.mercury.shippingservice.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shipments")
public class Shipment {

	@Id
	public String id;

	public int orderId;
	public ShippingStatus status;

	public Shipment() {
		super();
	}

	public Shipment(String id, int orderId, ShippingStatus status) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public ShippingStatus getStatus() {
		return status;
	}

	public void setStatus(ShippingStatus status) {
		this.status = status;
	}

}
