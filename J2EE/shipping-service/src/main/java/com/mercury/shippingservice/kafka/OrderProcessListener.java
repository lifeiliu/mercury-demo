package com.mercury.shippingservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mercury.core.bean.OrderMessage;
import com.mercury.shippingservice.bean.Shipment;
import com.mercury.shippingservice.bean.ShippingStatus;
import com.mercury.shippingservice.service.ShipmentService;

@Component
public class OrderProcessListener {
	
	@Autowired
	ShipmentService shipmentService;

	@KafkaListener(topics = "orders")
	public void handle(OrderMessage orderMessage) {
		Shipment shipment = new Shipment();
		shipment.setOrderId(orderMessage.getOrder_id());
		shipment.setStatus(ShippingStatus.PROCESSING);
		shipmentService.addShipment(shipment);
	}

}
