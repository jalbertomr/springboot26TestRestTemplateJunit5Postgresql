package com.bext.resttemplate.service;

import java.util.List;

import com.bext.resttemplate.entity.Employee;

public interface EmployeeService {
   public abstract Employee createEmployee(Employee employee);
   public abstract void updateEmployee(Employee employee);
   public abstract Employee getEmployee(Long id);
   public abstract List<Employee> getEmployees();
   public abstract void deleteEmployee(Long id);
   public abstract boolean employeeExist(Long id);
}
