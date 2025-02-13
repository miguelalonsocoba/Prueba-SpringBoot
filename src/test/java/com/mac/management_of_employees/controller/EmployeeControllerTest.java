package com.mac.management_of_employees.controller;

import com.mac.management_of_employees.config.LoadPreconfiguration;
import com.mac.management_of_employees.domain.entity.Employee;
import com.mac.management_of_employees.service.IEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {

    @Mock
    private IEmployeeService employeeServiceMock;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setupEach() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    void findAllSuccessfulTest() {
        Mockito.when(employeeServiceMock.findAll()).thenReturn(LoadPreconfiguration.getEmployees());
        List<Employee> employees = employeeController.findAll().getBody();
        Mockito.verify(employeeServiceMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).findAll();
        assertNotNull(employees, "Returned employees is null");
    }

    @Test
    void deleteByIdSuccessfulTest() {
        Mockito.doNothing().when(employeeServiceMock).deleteById(Mockito.anyInt());
        employeeController.deleteById(LoadPreconfiguration.ID);
        Mockito.verify(employeeServiceMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).deleteById(LoadPreconfiguration.ID);
    }

    @Test
    void saveSuccessfulTest() {
        Mockito.doNothing().when(employeeServiceMock).save(Mockito.any(Employee.class));
        employeeController.save(LoadPreconfiguration.getEmployees().get(LoadPreconfiguration.ID));
        Mockito.verify(employeeServiceMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).save(Mockito.any(Employee.class));
    }

    @Test
    void saveAllSuccessfulTest() {
        Mockito.doNothing().when(employeeServiceMock).saveAll(Mockito.anyList());
        employeeController.saveAll(LoadPreconfiguration.getEmployees());
        Mockito.verify(employeeServiceMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).saveAll(Mockito.anyList());
    }

    @Test
    void updateSuccessfulTest() {
        Mockito.doNothing().when(employeeServiceMock).save(Mockito.any(Employee.class));
        employeeController.update(LoadPreconfiguration.getEmployees().get(LoadPreconfiguration.ID));
        Mockito.verify(employeeServiceMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).save(Mockito.any(Employee.class));
    }

}