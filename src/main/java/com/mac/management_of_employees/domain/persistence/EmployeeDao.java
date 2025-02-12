package com.mac.management_of_employees.domain.persistence;

import com.mac.management_of_employees.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeDao is an interface that extends the JpaRepository interface for interacting with the database
 * containing Employee entities. It provides CRUD operations and additional database interaction methods
 * for the Employee entity using Spring Data JPA.
 * This interface manages Employee entities which represent employees within the system. The primary key of
 * Employee entities is of type Integer.
 */
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
