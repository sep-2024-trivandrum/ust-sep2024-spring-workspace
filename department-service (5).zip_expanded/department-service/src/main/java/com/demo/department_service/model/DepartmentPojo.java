package com.demo.department_service.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentPojo {
	private long deptId;
	private String deptName;
	private List<EmployeePojo> allEmployees;
	
}
