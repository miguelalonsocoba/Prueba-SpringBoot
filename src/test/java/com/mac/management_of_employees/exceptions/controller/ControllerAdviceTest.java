package com.mac.management_of_employees.exceptions.controller;

import com.mac.management_of_employees.exceptions.dto.ErrorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerAdviceTest {

    private ControllerAdvice controllerAdvice;

    @BeforeEach
    public void setUp() {
        controllerAdvice = new ControllerAdvice();
    }

    @Test
    void dataIntegrityViolationExceptionHandlerSuccessfulTest() {
        DataIntegrityViolationException exception = new DataIntegrityViolationException("DataIntegrityViolationException: Cannot add or update a child row: a foreign key constraint fails");
        ResponseEntity<ErrorDTO> responseEntity = controllerAdvice.dataIntegrityViolationExceptionHandler(exception);
        assertNotNull(responseEntity, "responseEntity is null");
        assertEquals(ResponseEntity.class, responseEntity.getClass(), "responseEntity is not type of ResponseEntity");
        assertEquals(HttpStatus.CONFLICT.value(), responseEntity.getStatusCode().value(), "status code is not expected");
    }

    @Test
    void notFoundExceptionHandlerSuccessfulTest() {
        NoHandlerFoundException exception = new NoHandlerFoundException("NoHandlerFoundException: Request method 'POST' not supported", null, null);
        ResponseEntity<ErrorDTO> responseEntity = controllerAdvice.notFoundExceptionHandler(exception);
        assertNotNull(responseEntity, "responseEntity is null");
        assertEquals(ResponseEntity.class, responseEntity.getClass(), "responseEntity is not type of ResponseEntity");
        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCode().value(), "status code is not expected");
    }

    @Test
    void validationExceptionHandler() {
        MethodArgumentTypeMismatchException exception = new MethodArgumentTypeMismatchException(null, null, null, null, null);
        ResponseEntity<ErrorDTO> responseEntity = controllerAdvice.validationExceptionHandler(exception);
        assertNotNull(responseEntity, "responseEntity is null");
        assertEquals(ResponseEntity.class, responseEntity.getClass(), "responseEntity is not type of ResponseEntity");
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCode().value(), "status code is not expected");
    }

    @Test
    void emptyResultDataAccessExceptionHandler() {
        EmptyResultDataAccessException exception = new EmptyResultDataAccessException(1);
        ResponseEntity<ErrorDTO> responseEntity = controllerAdvice.emptyResultDataAccessExceptionHandler(exception);
        assertNotNull(responseEntity, "responseEntity is null");
        assertEquals(ResponseEntity.class, responseEntity.getClass(), "responseEntity is not type of ResponseEntity");
        assertEquals(HttpStatus.NO_CONTENT.value(), responseEntity.getStatusCode().value(), "status code is not expected");
    }

    @Test
    void exceptionHandler() {
        Exception exception = new Exception("Exception: Something went wrong");
        ResponseEntity<ErrorDTO> responseEntity = controllerAdvice.exceptionHandler(exception);
        assertNotNull(responseEntity, "responseEntity is null");
        assertEquals(ResponseEntity.class, responseEntity.getClass(), "responseEntity is not type of ResponseEntity");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), responseEntity.getStatusCode().value(), "status code is not expected");
    }

}