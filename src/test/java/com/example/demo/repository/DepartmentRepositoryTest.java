package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Test
	void whenDepartmentByIdCalled_thenDepartmentFound() {
		Department department =
                Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentCode("ME - 011")
                .departmentAddress("Delhi")
                .build();

		testEntityManager.persist(department);
		
		Department department1 = departmentRepository.findByDepartmentName("Mechanical Engineering");
        System.out.println("IDDDDDDDDDDDDDDDDDDDDDD: " + department1.getDepartmentId());
		assertEquals("Mechanical Engineering", department1.getDepartmentName());
	}
}
