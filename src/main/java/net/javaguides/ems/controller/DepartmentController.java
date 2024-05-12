package net.javaguides.ems.controller;

import java.util.List;

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
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	private DepartmentService depService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment (@RequestBody DepartmentDto depDto){
		
		DepartmentDto savedDepartment = depService.createDepartment(depDto);
		
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById (@PathVariable("id") Long depId) {
		
		DepartmentDto departmentDto = depService.getDepartmentById(depId);
		
		return ResponseEntity.ok(departmentDto);
	}
	
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartment () {
		
		List<DepartmentDto> departments = depService.getAllDepartments();
		
		return ResponseEntity.ok(departments);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment (@PathVariable("id") Long depId,@RequestBody DepartmentDto updateDepartment) {
		
		DepartmentDto departmentDto = depService.updateDepartment(depId, updateDepartment);
		
		return ResponseEntity.ok(departmentDto);		
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment (@PathVariable("id") Long depId) {
		
		depService.deleteDepartment(depId);
		
		return ResponseEntity.ok("Department deleted successfully!");
	}
	
	
	

}
