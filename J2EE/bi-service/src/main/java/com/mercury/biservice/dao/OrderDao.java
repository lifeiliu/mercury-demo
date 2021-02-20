package com.mercury.biservice.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mercury.biservice.bean.Order;

@EnableScan
public interface OrderDao extends CrudRepository<Order, Integer> {

}
