package com.demo.monolithic_spring_security_product.entity;

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
@Table(name="roles_details")
public class Roles {
	@Id
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
}
