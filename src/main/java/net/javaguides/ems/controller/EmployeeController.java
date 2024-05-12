package net.javaguides.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	// create Emp api
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto empDto){
		System.out.println("Hello");
		EmployeeDto savedEmployee = empService.createEmployee(empDto);
		
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	
	// get Emp api
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long empId) {
		
		EmployeeDto employeeDto = empService.getEmployeeById(empId);
		
		return ResponseEntity.ok(employeeDto);
	}
	
	
	// getAll Emp api
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		
		List<EmployeeDto> employees = empService.getAllEmployees();
		
		return ResponseEntity.ok(employees);
	}
	
	
	// update Emp api
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId,@RequestBody EmployeeDto updatedEmp){
		
		EmployeeDto employeeDto = empService.updateEmployee(empId, updatedEmp);
		
		return ResponseEntity.ok(employeeDto);		
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee (@PathVariable("id") Long empId) {
		
		empService.deleteEmployee(empId);
		
		return ResponseEntity.ok("Employee deleted successfully!");
	}
	
	
	

}
