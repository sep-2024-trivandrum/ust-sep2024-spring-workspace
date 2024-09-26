package com.demo.department_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.department_service.dao.DepartmentRepository;
import com.demo.department_service.dao.entity.DepartmentEntity;
import com.demo.department_service.model.DepartmentPojo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	DepartmentRepository deptRepo;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository deptRepo) {
		this.deptRepo = deptRepo;
	}
	
	@Override
	public List<DepartmentPojo> getAllDepartments() {
		List<DepartmentEntity> allDeptEntity = deptRepo.findAll();
		List<DepartmentPojo> allDeptPojo = new ArrayList<>();
		allDeptEntity.stream().forEach((eachDeptEntity) -> {
			DepartmentPojo deptPojo = new DepartmentPojo();
			BeanUtils.copyProperties(eachDeptEntity, deptPojo);
			allDeptPojo.add(deptPojo);
		});
		return allDeptPojo;
	}

	@Override
	public DepartmentPojo getADepartment(long deptId) {
		Optional<DepartmentEntity> fetchedDeptEntity = deptRepo.findById(deptId);
		DepartmentPojo deptPojo = null;
		if(fetchedDeptEntity.isPresent()) {
			deptPojo = new DepartmentPojo();
			BeanUtils.copyProperties(fetchedDeptEntity.get(), deptPojo);
		}
		return deptPojo;
	}

	@Override
	public DepartmentPojo addDepartment(DepartmentPojo newDepPojo) {
		DepartmentEntity deptEntity = new DepartmentEntity();
		BeanUtils.copyProperties(newDepPojo, deptEntity);
		deptRepo.saveAndFlush(deptEntity);
		return newDepPojo;
	}

	@Override
	public DepartmentPojo updateDepartment(DepartmentPojo editDepPojo) {
		DepartmentEntity deptEntity = new DepartmentEntity();
		BeanUtils.copyProperties(editDepPojo, deptEntity);
		deptRepo.saveAndFlush(deptEntity);
		return editDepPojo;
	}

	@Override
	public void deleteDepartment(long deptId) {
		deptRepo.deleteById(deptId);
	}
}
