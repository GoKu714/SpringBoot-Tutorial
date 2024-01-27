package com.example.demo.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	@NotBlank(message = "Kalat nahi ka re tula empty department name pathvt ahe")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
