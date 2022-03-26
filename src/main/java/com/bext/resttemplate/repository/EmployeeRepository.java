package com.bext.resttemplate.repository;

import org.springframework.data.repository.CrudRepository;
import com.bext.resttemplate.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
