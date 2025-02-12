package com.mac.management_of_employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Management of Employees application.
 * This class serves as the entry point for the Spring Boot application.
 * It configures and starts the application using the SpringApplication.run method.
 */
@SpringBootApplication
public class ManagementOfEmployeesApplication {

	/**
	 * The entry point of the Management of Employees application.
	 * This method bootstraps the Spring Boot application using the provided arguments.
	 *
	 * @param args array of command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(ManagementOfEmployeesApplication.class, args);
	}

}
