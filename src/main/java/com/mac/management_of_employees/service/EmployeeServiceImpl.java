package com.mac.management_of_employees.service;

import com.mac.management_of_employees.domain.entity.Employee;
import com.mac.management_of_employees.domain.persistence.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * EmployeeServiceImpl is a service implementation class responsible for managing Employee entities.
 * It provides methods for retrieving, saving, and deleting employee data while interacting with the
 * underlying data layer through the EmployeeDao interface. This class follows the contract defined
 * in the IEmployeeService interface.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    /**
     * Logger instance used for logging messages and events occurring within the EmployeeServiceImpl class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /**
     * A data access object (DAO) for performing database operations on Employee entities.
     * This instance is responsible for interacting with the database via Spring Data JPA to provide
     * methods such as retrieving, saving, and deleting employee records.
     */
    private final EmployeeDao employeeDao;

    /**
     * Constructs a new instance of EmployeeServiceImpl with the specified EmployeeDao.
     * This constructor initializes the data access object used for performing database
     * operations related to Employee entities.
     *
     * @param employeeDao the data access object responsible for Employee entity operations
     */
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * Retrieves all employee records from the database.
     *
     * @return a list of Employee objects representing all employee records.
     * @throws EmptyResultDataAccessException if no employee records are found.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        LOGGER.debug("Executing method findAll()");
        List<Employee> employees = employeeDao.findAll();
        if (employees.isEmpty()) {
            LOGGER.warn("No records found in the database");
            throw new EmptyResultDataAccessException("No records found in the database", 0);
        }
        LOGGER.debug("Employees found: {}", employees);
        return employees;
    }

    /**
     * Deletes an employee record from the database by its unique identifier.
     * This operation is transactional to ensure consistency during execution.
     *
     * @param id the unique identifier of the employee to be deleted
     */
    @Override
    @Transactional
    public void deleteById(Integer id) {
        LOGGER.debug("Executing method deleteById()");
        employeeDao.deleteById(id);
        LOGGER.debug("Employee {} deleted", id);
    }

    /**
     * Persists the given Employee object to the database.
     *
     * @param employee the Employee object to be saved.
     */
    @Override
    @Transactional
    public void save(Employee employee) {
        LOGGER.debug("Executing method save()");
        employeeDao.save(employee);
        LOGGER.debug("Employee saved {}", employee);
    }

    /**
     * Saves a list of Employee entities in the database.
     *
     * @param employees the list of Employee objects to be saved.
     */
    @Override
    public void saveAll(List<Employee> employees) {
        LOGGER.debug("Executing method saveAll()");
        employeeDao.saveAll(employees);
        LOGGER.debug("Employees saved {}", employees);
    }
}
