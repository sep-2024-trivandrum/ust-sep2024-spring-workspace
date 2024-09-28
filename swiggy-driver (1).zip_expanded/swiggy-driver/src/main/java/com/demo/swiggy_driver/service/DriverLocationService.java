package com.demo.swiggy_driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.swiggy_driver.constants.AppConstants;

@Service
public class DriverLocationService {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		kafkaTemplate.send(AppConstants.DRIVER_LOCATION, location);
		return true;
	}
}
