package com.demo.employee_service.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class EmployeeEntity {
	@Id
	private long empId;
	private String empName;
	private String empDesignation;
	private long empDeptId;
}
