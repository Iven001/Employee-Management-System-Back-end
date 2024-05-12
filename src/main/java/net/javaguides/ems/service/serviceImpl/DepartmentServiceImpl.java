package net.javaguides.ems.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.mapper.DepartmentMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository depRepository;
	
	@Override
	public DepartmentDto createDepartment(DepartmentDto depDto) {
		
		Department department = DepartmentMapper.mapToDepartment(depDto);
		Department savedDepartment = depRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDepartmentById(Long depId) {
		
		Department department = depRepository.findById(depId)
				.orElseThrow();
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		
		List<Department> departments = depRepository.findAll();
		return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long depId, DepartmentDto updateDepartment) {
		
		Department department = depRepository.findById(depId).orElseThrow();

		department.setDepartmentName(updateDepartment.getDepartmentName());
		department.setDepartmentDescription(updateDepartment.getDepartmentDescription());
		
		Department updatedDepartment = depRepository.save(department);
		
		return DepartmentMapper.mapToDepartmentDto(updatedDepartment);
	}

	@Override
	public void deleteDepartment(Long depId) {
		
		Department department = depRepository.findById(depId).orElseThrow();
		depRepository.deleteById(depId);
	}

}
