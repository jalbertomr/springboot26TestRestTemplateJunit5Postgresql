# SpringBoot 2.6 RESTweb TestRestTemplate Employee junit5 Postgresql
# database initialized 
##### description

  The project is a simple web employee controller with CRUD functionality with uri
  https://localhost:8080/employees
  
  It uses postgresql database which configuration is in application.properties file
  
  it also uses schema.sql and data.sql to create and initialize the database when properties
  are spring.jpa.hibernate.ddl-auto = none, otherwise the database and table can be created
  with spring.jpa.hibernate.ddl-auto = create-drop. 
  
  Independently to the table creation option, in the application records are created using
  employeeRepository.

  the schema.sql creates the sequence for the employee.id
  
####  Specify auto or scripted creation of table
  
  Auto by spring hibernate
  
  spring.sql.init.mode= never
  spring.jpa.hibernate.ddl-auto = create-drop
  
  Manual by scripts and init data with data.sql
  
  spring.sql.init.mode= always
  spring.jpa.hibernate.ddl-auto = none
  
  
  in application.properties declare
  
    spring.sql.init.schema-locations=classpath:db/schema.sql
    spring.sql.init.data-locations=classpath:db/data.sql
  
  So in src/main/resources/db create the script files schema.sql, data.sql
  
#### To test with TestRestTemplate

    @Autowired
	 private TestRestTemplate testRestTemplate;
     
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
     

#### Test Ordered

The set of crud test are ordered in order to pass with

	 @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class EmployeeControllerTest {
	
	 ...
	 
	 @Test
	 @Order(2)
	 void createEmployeeSuccess() throws URISyntaxException {
	
	