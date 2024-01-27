package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		logger.info("Inside getAllDepartments of DepartmentController");
		return departmentService.getDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {
		return departmentService.getDepartment(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public void deleteDepartment(@PathVariable("id") Long id) {
		departmentService.deleteDepartment(id);
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
		return departmentService.updateDepartment(id, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String name) {
		return departmentService.getDepartment(name);
	}
}
