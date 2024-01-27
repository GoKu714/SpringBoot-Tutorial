package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(Long id) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(id);
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not available.");
		}
		
		return department.get();
		
	}

	@Override
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department departmentToBeUpdated  = departmentRepository.findById(id).get();
		
		if (department.getDepartmentName() != null && !department.getDepartmentName().isBlank()) {
			departmentToBeUpdated.setDepartmentName(department.getDepartmentName());  
		}
		
		if (department.getDepartmentCode() != null && !department.getDepartmentCode().isBlank()) {
			departmentToBeUpdated.setDepartmentCode(department.getDepartmentCode());  
		}
		
		if (department.getDepartmentAddress() != null && !department.getDepartmentAddress().isBlank()) {
			departmentToBeUpdated.setDepartmentAddress(department.getDepartmentAddress());  
		}
		
		return departmentRepository.save(departmentToBeUpdated);
	}

	@Override
	public Department getDepartment(String name) {
		return departmentRepository.findByDepartmentNameIgnoreCase(name);
	}
	
}
