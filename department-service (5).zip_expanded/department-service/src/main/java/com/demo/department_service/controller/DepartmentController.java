package com.demo.department_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.demo.department_service.model.DepartmentPojo;
import com.demo.department_service.model.EmployeePojo;
import com.demo.department_service.service.DepartmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	DepartmentService deptService;
	
	public static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	public DepartmentController(DepartmentService deptService) {
		this.deptService = deptService;
	}
	
	@GetMapping("/departments")
	public List<DepartmentPojo> getAllDpartments(){
		LOG.info("in getAllDepartments()");
		return deptService.getAllDepartments();
	}
	
	@GetMapping("/departments/{did}")
	@CircuitBreaker(name="ciremp", fallbackMethod = "empFallBack")
	public DepartmentPojo getADepartment(@PathVariable("did") long deptId) {
		LOG.info("in getADepartment()");
		DepartmentPojo deptPojo = deptService.getADepartment(deptId);
		RestClient restClient = RestClient.create();
		List<EmployeePojo> allEmps = restClient
			.get()
			.uri("http://employee-sr:8082/api/employees/departments/" + deptId)
			.retrieve()
			.body(List.class);
		deptPojo.setAllEmployees(allEmps);
		return deptPojo;
	}
	
	public DepartmentPojo empFallBack() {
		return new DepartmentPojo(0, "fallback", null);
	}
	
	@PostMapping("/departments")
	public DepartmentPojo addDepartment(@RequestBody DepartmentPojo newDept) {
		LOG.info("in addDepartment()");
		return deptService.addDepartment(newDept);
	}
	
	@PutMapping("/departments")
	public DepartmentPojo updateDepartment(@RequestBody DepartmentPojo editDept) {
		LOG.info("in updateDepartment()");
		return deptService.updateDepartment(editDept);
	}
	
	@DeleteMapping("/departments/{did}")
	public void removeDepartment(@PathVariable("did") long deptId) {
		LOG.info("in removeDepartment()");
		deptService.deleteDepartment(deptId);
	}
}
