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

@RestController
@RequestMapping(value = "/employees", headers = "X-API_VERSION=1.0.0")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        LOGGER.debug("Executing method findAll()");
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(value = "id") Integer id) {
        LOGGER.debug("Executing method deleteById()");
        employeeService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Employee employee) {
        LOGGER.debug("Executing method save()");
        employeeService.save(employee);
    }

    @PostMapping(value = "/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAll(@RequestBody List<Employee> employees) {
        LOGGER.debug("Executing method saveAll()");
        employeeService.saveAll(employees);
    }

}
