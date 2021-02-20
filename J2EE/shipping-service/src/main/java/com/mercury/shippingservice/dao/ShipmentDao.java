package com.mercury.shippingservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mercury.shippingservice.bean.Shipment;

public interface ShipmentDao extends MongoRepository<Shipment, String>{

}
