package com.mac.management_of_employees.service;

import com.mac.management_of_employees.domain.entity.Employee;
import com.mac.management_of_employees.domain.persistence.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

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

    @Override
    @Transactional
    public void deleteById(Integer id) {
        LOGGER.debug("Executing method deleteById()");
        employeeDao.deleteById(id);
        LOGGER.debug("Employee {} deleted", id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        LOGGER.debug("Executing method save()");
        employeeDao.save(employee);
        LOGGER.debug("Employee saved {}", employee);
    }

    @Override
    public void saveAll(List<Employee> employees) {
        LOGGER.debug("Executing method saveAll()");
        employeeDao.saveAll(employees);
        LOGGER.debug("Employees saved {}", employees);
    }
}
