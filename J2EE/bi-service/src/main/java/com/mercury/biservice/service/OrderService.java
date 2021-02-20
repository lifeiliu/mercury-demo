package com.mercury.biservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercury.biservice.bean.Order;
import com.mercury.biservice.dao.OrderDao;

@Component
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	public void saveOrder(Order order) {
		orderDao.save(order);
	}
	
}
