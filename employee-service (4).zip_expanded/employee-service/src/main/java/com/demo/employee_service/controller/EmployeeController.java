package com.demo.employee_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee_service.dao.EmployeeRepository;
import com.demo.employee_service.dao.entity.EmployeeEntity;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	public static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeController(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@GetMapping("/employees")
	public List<EmployeeEntity> getAllEmployees(){
		return empRepo.findAll();
	}
	
	@GetMapping("/employees/departments/{did}")
	public List<EmployeeEntity> getAllEmployeesByDepartment(@PathVariable long did){
		return empRepo.findByEmpDeptId(did);
	}
	
	@PostMapping("/employees")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity newEmp) {
		return empRepo.saveAndFlush(newEmp);
	}
}
