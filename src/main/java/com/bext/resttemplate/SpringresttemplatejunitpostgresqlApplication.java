package com.bext.resttemplate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bext.resttemplate.entity.Employee;
import com.bext.resttemplate.repository.EmployeeRepository;

@SpringBootApplication
public class SpringresttemplatejunitpostgresqlApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(SpringresttemplatejunitpostgresqlApplication.class, args);
	}

}
