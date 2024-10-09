package com.demo.spring_lambda_vehicle_demo.model;

public class VehicleDto {
	private int vehicleId;
	private String vehicleName;
	
	public VehicleDto() {}

	public VehicleDto(int vehicleId, String vehicleName) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	@Override
	public String toString() {
		return "VehicleDto [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + "]";
	}
	
	
}
