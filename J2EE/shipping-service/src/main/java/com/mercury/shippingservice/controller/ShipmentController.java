package com.mercury.shippingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.shippingservice.bean.Response;
import com.mercury.shippingservice.bean.Shipment;
import com.mercury.shippingservice.service.ShipmentService;

@RestController
public class ShipmentController {
	
	@Autowired
	ShipmentService shipmentService;

	@GetMapping("/shipments")
	public List<Shipment> getShipments(){
		return shipmentService.getAllShippments();
	}
	
	@PostMapping("/shipments")
	public Response postShipment(@RequestBody Shipment shipment) {
		return shipmentService.addShipment(shipment);
	}
	
}
