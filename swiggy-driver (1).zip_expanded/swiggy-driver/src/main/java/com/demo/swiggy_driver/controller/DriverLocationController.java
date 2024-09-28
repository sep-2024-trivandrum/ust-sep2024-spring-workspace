package com.demo.swiggy_driver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.swiggy_driver.service.DriverLocationService;

@RestController
@RequestMapping("/api")
public class DriverLocationController {

	@Autowired
	DriverLocationService driverLocationService;
	
	@PutMapping("/locations")
	public ResponseEntity<Map<String, Object>> updateLocation() throws InterruptedException{
		int range = 100;
		while(range > 0) {
			String cordinates = Math.random() + " , " + Math.random();
			//System.out.println(cordinates);
			driverLocationService.updateLocation(cordinates);
			Thread.sleep(100);
			range--;
		}
		return new ResponseEntity<Map<String, Object>>(Map.of("message","Location Updated!"), HttpStatus.OK);
	}
}
