package com.demo.department_service.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="department_details")
public class DepartmentEntity {
	@Id
	@Column(name="dept_id")
	private long deptId;
	
	@Column(name="dept_name")
	private String deptName;
}
