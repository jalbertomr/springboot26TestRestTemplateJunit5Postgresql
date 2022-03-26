package com.bext.resttemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bext.resttemplate.entity.Employee;
import com.bext.resttemplate.exception.EmployeeNotFoundException;
import com.bext.resttemplate.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value ="/employees", method=RequestMethod.POST)
	public ResponseEntity<String> createEmployee(
			@RequestHeader(name = "X-RAM-PERSIST", required = true) String headerPersist,
			@RequestBody Employee employee) {
		employee = employeeService.createEmployee(employee);
		return new ResponseEntity<>("Employee created with ID: " + employee.getId(), HttpStatus.CREATED);
	}
	
	@RequestMapping( value = "/employees/{id}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		if (employeeService.employeeExist(id)) {
			employee.setId(id);
			employeeService.updateEmployee(employee);
			return new ResponseEntity<>("Employee Updated!", HttpStatus.OK);
		} else {
			throw new EmployeeNotFoundException();
		}
	}
	
	@RequestMapping( value = "/employees/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable("id") Long id) {
		if (employeeService.employeeExist(id)) {
			return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
		} else {
		   throw new EmployeeNotFoundException();
		}
	}
	
	@RequestMapping(value ="/employees", method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<>( employeeService.getEmployees(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/employees/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		if (employeeService.employeeExist(id)) {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>("Employee Deleted!", HttpStatus.OK);
		} else {
			throw new EmployeeNotFoundException();
		}
	}
}
