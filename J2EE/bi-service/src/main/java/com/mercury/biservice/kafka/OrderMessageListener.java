package com.mercury.biservice.kafka;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mercury.biservice.bean.Order;
import com.mercury.biservice.service.OrderService;
import com.mercury.core.bean.OrderMessage;

@Component
public class OrderMessageListener {
	
	@Autowired
	OrderService orderService;

	@KafkaListener(topics = "orders")
	public void handle(OrderMessage orderMessage) {
		Map<String, Integer> products = new HashMap<>();
		orderMessage.getProducts().forEach((k, v) -> {
			products.put(String.valueOf(k), v);
		});
		Order order = new Order(orderMessage.getOrder_id(), orderMessage.getPurchase_date(), products);
		orderService.saveOrder(order);
	}
	
}
