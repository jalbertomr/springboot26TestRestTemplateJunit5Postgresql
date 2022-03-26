package com.bext.resttemplate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
    private double salary;
	
    public Employee() {
		super();
	}

	public Employee( String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

   
}

/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

 * -- Table: public.employee   AS CREATED IN POSTGRESQL AUTO

-- DROP TABLE public.employee;

CREATE TABLE public.employee
(
    id bigint NOT NULL DEFAULT nextval('employee_id_seq'::regclass),
    age integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    salary integer NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;
*/

/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  AND GenerationType.SEQUENCE
	private Long id;
	
 * 
 * -- Table: public.employee


-- DROP TABLE public.employee;

CREATE TABLE public.employee
(
    id bigint NOT NULL,
    age integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    salary integer NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;
    
    
    
    GRANT USAGE, select ON SEQUENCE employee_id_seq TO user;
    ALTER SEQUENCE employee_id_seq RESTART WITH 1;
UPDATE employee_id_seq SET last_value=nextval('employee_id_seq');
select * from employee_id_seq;
*/

