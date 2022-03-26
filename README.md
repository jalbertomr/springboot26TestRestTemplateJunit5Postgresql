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