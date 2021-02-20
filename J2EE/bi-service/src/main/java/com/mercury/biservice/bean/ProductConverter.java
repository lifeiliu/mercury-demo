package com.mercury.biservice.bean;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class ProductConverter implements DynamoDBTypeConverter<Integer, Integer> {

	@Override
	public Integer convert(Integer count) {
		return count;
	}

	@Override
	public Integer unconvert(Integer count) {
		return count;
	}

}
