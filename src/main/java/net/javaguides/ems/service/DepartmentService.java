package net.javaguides.ems.service;

import java.util.List;

import net.javaguides.ems.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto createDepartment(DepartmentDto depDto);
	
	DepartmentDto getDepartmentById (Long depId);
	
	List<DepartmentDto> getAllDepartments();
	
	DepartmentDto updateDepartment(Long depId, DepartmentDto updateDepartment);

	void deleteDepartment(Long depId);
	
}
