package com.mac.management_of_employees.controller;

import com.mac.management_of_employees.domain.entity.Employee;
import com.mac.management_of_employees.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * EmployeeController is a REST controller that manages employee-related operations.
 * It provides endpoints to perform CRUD operations on Employee resources.
 * The controller is mapped to the "/employees" base URL and requires the "X-API_VERSION=1.0.0" header
 * for API versioning.
 */
@RestController
@RequestMapping(value = "/employees", headers = "X-API_VERSION=1.0.0")
public class EmployeeController {

    /**
     * Logger instance for logging events and debug information in the EmployeeController class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * Service layer dependency for handling employee-related business logic.
     */
    private final IEmployeeService employeeService;

    /**
     * Constructs an {@code EmployeeController} with the specified service layer dependency.
     *
     * @param employeeService the service layer used to handle employee-related business logic
     */
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieves a list of all employees.
     *
     * @return a ResponseEntity containing a list of all employees with an HTTP status of OK
     */
    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        LOGGER.debug("Executing method findAll()");
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    /**
     * Deletes an employee resource identified by its unique ID.
     *
     * @param id the unique identifier of the employee to be deleted
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(value = "id") Integer id) {
        LOGGER.debug("Executing method deleteById()");
        employeeService.deleteById(id);
    }

    /**
     * Persists a new employee record in the data store.
     * The request body must contain the employee details to be saved.
     *
     * @param employee the employee object containing the details to be persisted
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Employee employee) {
        LOGGER.debug("Executing method save()");
        employeeService.save(employee);
    }

    /**
     * Persists a batch of employee records in the data store.
     * The request body must contain a list of employee objects to be saved.
     *
     * @param employees a list of employee objects containing the details to be persisted
     */
    @PostMapping(value = "/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAll(@RequestBody List<Employee> employees) {
        LOGGER.debug("Executing method saveAll()");
        employeeService.saveAll(employees);
    }

}
