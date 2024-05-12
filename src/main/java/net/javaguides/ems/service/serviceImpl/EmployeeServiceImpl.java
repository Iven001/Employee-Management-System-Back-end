package net.javaguides.ems.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.DepartmentRepository;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.service.EmployeeService;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository empRepository;
	
	private DepartmentRepository depRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(empDto);
		
		Department department = depRepository.findById(empDto.getDepartmentId())
				.orElseThrow();
		
		employee.setDepartment(department);
		
		Employee savedEmployee = empRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		
		Employee employee = empRepository.findById(employeeId)
				 .orElseThrow();
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> employees = empRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

		
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		
		Employee employee = empRepository.findById(employeeId).orElseThrow();
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setMail(updatedEmployee.getMail());
		
		Department department = depRepository.findById(updatedEmployee.getDepartmentId())
				.orElseThrow();
		
		employee.setDepartment(department);
		
		Employee updatedEmployeeObj = empRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = empRepository.findById(employeeId).orElseThrow();
		empRepository.deleteById(employeeId);
		
	}

}
