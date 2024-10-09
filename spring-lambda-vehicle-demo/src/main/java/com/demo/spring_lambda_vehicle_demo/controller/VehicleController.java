package com.demo.spring_lambda_vehicle_demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_lambda_vehicle_demo.model.VehicleDto;

@RestController
@RequestMapping("/api")
public class VehicleController {

	List<VehicleDto> allVehicles = List.of(new VehicleDto(101, "Car"));
	
	@GetMapping("/vehicles")
	public List<VehicleDto> getAllVehicles() {
		return allVehicles;
	}
	
	@PostMapping("/vehicles")
	public VehicleDto addVehicle(@RequestBody VehicleDto newVehicle) {
		allVehicles.add(newVehicle);
		return newVehicle;
	}
}
