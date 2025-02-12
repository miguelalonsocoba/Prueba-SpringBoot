package com.mac.management_of_employees.domain.persistence;

import com.mac.management_of_employees.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
