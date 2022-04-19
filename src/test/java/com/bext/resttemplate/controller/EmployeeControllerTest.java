package com.bext.resttemplate.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bext.resttemplate.entity.Employee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	@Order(2)
	void createEmployeeSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/employees/";
		URI uri = new URI(baseUrl);
		Employee employee = new Employee("Hugo", 7, 77777.777);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("X-RAM-PERSIST", "true");

		HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, httpHeaders);

		ResponseEntity<String> postForEntity = this.testRestTemplate.postForEntity(uri, httpEntity, String.class);

		Assertions.assertEquals(201, postForEntity.getStatusCodeValue());
	}

	@Test
	@Order(1)
	void createEmployeeWithOutHeader() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/employees/";
		URI uri = new URI(baseUrl);
		Employee employee = new Employee("Hugo", 7, 77777.777);

		HttpHeaders httpHeaders = new HttpHeaders();
		// httpHeaders.set("X-RAM-PERSIST", "true");

		HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, httpHeaders);

		ResponseEntity<String> postForEntity = this.testRestTemplate.postForEntity(uri, httpEntity, String.class);

		Assertions.assertEquals(400, postForEntity.getStatusCodeValue());
	}

	@Test
	@Order(3)
	void getEmployeeSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/employees/1";
		URI uri = new URI(baseUrl);
		ResponseEntity<Employee> rsEmployee = this.testRestTemplate.getForEntity(uri, Employee.class);
		Assertions.assertEquals(200, rsEmployee.getStatusCodeValue());
		Assertions.assertEquals("Hugo", rsEmployee.getBody().getName());
	}
	
	@Test
	@Order(4)
	void getEmployeesSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" +  randomServerPort + "/employees/";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> responseEntity = this.testRestTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	@Order(5)
	void updateEmployeeSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/employees/1";
		URI uri = new URI(baseUrl);
		Employee employee = new Employee("HugoUpdated", 8, 1234.222);

		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, httpHeaders);

		ResponseEntity<String> responseEntity = this.testRestTemplate.exchange(uri, HttpMethod.PUT, httpEntity,
				String.class);

		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	@Test
	@Order(6)
	void deleteEmployeeSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/employees/1";
		URI uri = new URI(baseUrl);
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<Employee> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<String> responseEntity = this.testRestTemplate.exchange(uri,  HttpMethod.DELETE, httpEntity, String.class);
		
		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
	}
}
