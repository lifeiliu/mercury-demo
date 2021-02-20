package com.mercury.shippingservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.shippingservice.bean.Response;
import com.mercury.shippingservice.bean.Shipment;
import com.mercury.shippingservice.dao.ShipmentDao;

@Service
public class ShipmentService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ShipmentService.class);

	@Autowired
	ShipmentDao shipmentDao;
	
	public List<Shipment> getAllShippments() {
		return shipmentDao.findAll();
	}
	
	public Response addShipment(Shipment shipment) {
		try {
			shipmentDao.save(shipment);
			return new Response(true);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new Response(false);
		}
	}
	
}
