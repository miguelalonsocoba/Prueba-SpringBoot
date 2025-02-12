package com.mac.management_of_employees.service;

import com.mac.management_of_employees.config.LoadPreconfiguration;
import com.mac.management_of_employees.domain.entity.Employee;
import com.mac.management_of_employees.domain.persistence.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeDao employeeDaoMock;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setupEach() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    void findAllSuccessfulTest() {
        Mockito.when(employeeDaoMock.findAll()).thenReturn(LoadPreconfiguration.getEmployees());
        List<Employee> employees = employeeService.findAll();
        Mockito.verify(employeeDaoMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).findAll();
        assertNotNull(employees, "Returned employees is null");
    }

    @Test
    void findAllEmptyResultDataAccessExceptionTest() {
        Mockito.when(employeeDaoMock.findAll()).thenReturn(List.of());
        assertThrows(EmptyResultDataAccessException.class, () -> employeeService.findAll());
    }

    @Test
    void deletedByIdSuccessfulTest() {
        Mockito.doNothing().when(employeeDaoMock).deleteById(Mockito.anyInt());
        employeeService.deleteById(LoadPreconfiguration.ID);
        Mockito.verify(employeeDaoMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).deleteById(Mockito.anyInt());
    }

    @Test
    void saveSuccessfulTest() {
        Mockito.when(employeeDaoMock.save(Mockito.any(Employee.class))).thenReturn(LoadPreconfiguration.getEmployees().get(LoadPreconfiguration.ID));
        employeeService.save(LoadPreconfiguration.getEmployees().get(LoadPreconfiguration.ID));
        Mockito.verify(employeeDaoMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).save(Mockito.any(Employee.class));
    }

    @Test
    void saveAllSuccessfulTest() {
        Mockito.when(employeeDaoMock.saveAll(Mockito.anyList())).thenReturn(LoadPreconfiguration.getEmployees());
        employeeService.saveAll(LoadPreconfiguration.getEmployees());
        Mockito.verify(employeeDaoMock, Mockito.times(LoadPreconfiguration.NUMBER_OF_INVOCATIONS)).saveAll(Mockito.anyList());
    }


}