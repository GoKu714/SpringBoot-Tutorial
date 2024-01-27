package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getDepartmentList();

	public Department getDepartment(Long id) throws DepartmentNotFoundException;

	public void deleteDepartment(Long id);

	public Department updateDepartment(Long id, Department department);

	public Department getDepartment(String name);

}
