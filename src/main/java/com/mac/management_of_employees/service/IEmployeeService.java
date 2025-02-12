package com.mac.management_of_employees.service;

import com.mac.management_of_employees.domain.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void deleteById(Integer id);
    void save(Employee employee);
    void saveAll(List<Employee> employees);
}
