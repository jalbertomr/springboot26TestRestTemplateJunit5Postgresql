package com.bext.resttemplate.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bext.resttemplate.entity.Employee;
import com.bext.resttemplate.repository.EmployeeRepository;
import com.bext.resttemplate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		Employee employee = optionalEmployee.get();
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public boolean employeeExist(Long id) {
		return employeeRepository.existsById(id);
	}

}
