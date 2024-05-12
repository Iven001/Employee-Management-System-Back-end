package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {

	// convert Employee jpa entity into Employee dto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getMail(),
                employee.getDepartment().getId()
        );
    }

 // convert Employee dto into Employee jpa entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
       Employee employee = new Employee();
       employee.setId(employeeDto.getId());
       employee.setFirstName(employeeDto.getFirstName());
       employee.setLastName(employeeDto.getLastName());
       employee.setMail(employeeDto.getMail());
       
       return employee;
    }
}