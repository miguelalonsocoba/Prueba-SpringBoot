package com.mac.management_of_employees.config;

import com.mac.management_of_employees.domain.entity.Employee;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LoadPreconfiguration {

    public static final Integer ID = 1;
    public static final Integer NUMBER_OF_INVOCATIONS = 1;

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(0, "John", "Doe", "John", "Doe", 30, "M", new Date(1990, 8, 27), "Manager"),
                new Employee(1, "Jane", "Doe", "Jane", "Doe", 25, "F", new Date(1995, 5, 15), "Developer"),
                new Employee(2, "Bob", "Smith", "Bob", "Smith", 35, "M", new Date(1985, 2, 10), "Designer")
        );
    }
}
