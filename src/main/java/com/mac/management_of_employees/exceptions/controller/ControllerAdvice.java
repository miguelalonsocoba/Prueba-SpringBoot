package com.mac.management_of_employees.exceptions.controller;

import com.mac.management_of_employees.exceptions.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

/**
 * A global exception handler for a RESTful application to handle various exceptions
 * and provide structured error responses using the ErrorDTO class.

 * This class leverages the @RestControllerAdvice annotation to intercept exceptions thrown by
 * controllers and return appropriate HTTP responses with meaningful error details.
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * A logger instance used for logging events, messages, and errors within the
     * ControllerAdvice class. This logger is configured to capture relevant
     * details for debugging and monitoring application behavior.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

    /**
     * Handles exceptions of type DataIntegrityViolationException. This method
     * responds with a structured error response containing details about the
     * exception and the associated HTTP conflict status.
     *
     * @param e the exception instance of type DataIntegrityViolationException
     *          thrown during the request processing.
     * @return a ResponseEntity containing an ErrorDTO object with error details
     *         and HTTP status code 409 (Conflict).
     */
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException e){
        LOGGER.warn("Data integrity violation: {}", e.getMessage());
        ErrorDTO error = new ErrorDTO();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setError(HttpStatus.CONFLICT.getReasonPhrase() + ": Data integrity violation");
        error.setException(e.getClass().getName());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(error);
    }

    /**
     * Handles exceptions of type NoHandlerFoundException. This method creates a
     * detailed error response containing information about the exception and returns
     * it with a 404 Not Found HTTP status code.
     *
     * @param e the NoHandlerFoundException instance that was thrown during request processing
     * @return a ResponseEntity containing an ErrorDTO object with error details
     *         and an HTTP status code of 404 (Not Found)
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundExceptionHandler(NoHandlerFoundException e) {
        LOGGER.warn("No driver found for the request: {}", e.getMessage());
        ErrorDTO error = new ErrorDTO();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        error.setException(e.getClass().getName());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    /**
     * Handles exceptions of type MethodArgumentTypeMismatchException.
     * This method creates a detailed error response object containing
     * specifics of the exception, such as the error type, message, and HTTP status.
     *
     * @param e the exception instance of type MethodArgumentTypeMismatchException
     *          that was thrown during the request processing
     * @return a ResponseEntity containing an ErrorDTO object with error details
     *         and an HTTP status code of 400 (Bad Request)
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> validationExceptionHandler(MethodArgumentTypeMismatchException e) {
        LOGGER.warn("Validation error in the arument: {}", e.getMessage());
        ErrorDTO error = new ErrorDTO();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError(HttpStatus.BAD_REQUEST.getReasonPhrase() + " Validation");
        error.setException(e.getClass().getName());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
    }

    /**
     * Handles exceptions of type EmptyResultDataAccessException.
     * This method creates a structured error response with detailed information
     * about the exception and responds with an HTTP 204 No Content status code.
     *
     * @param e the exception instance of type EmptyResultDataAccessException
     *          that was thrown during the request processing
     * @return a ResponseEntity containing an ErrorDTO object with error details
     *         and an HTTP status code of 204 (No Content)
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ErrorDTO> emptyResultDataAccessExceptionHandler(EmptyResultDataAccessException e) {
        LOGGER.warn("Empty result: {}", e.getMessage());
        ErrorDTO error = new ErrorDTO();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.NO_CONTENT.value());
        error.setError(HttpStatus.NO_CONTENT.getReasonPhrase() + " Empty result");
        error.setException(e.getClass().getName());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(error);
    }

    /**
     * Handles general exceptions of type {@link Exception}. This method constructs a detailed
     * error response containing information about the exception, such as the timestamp, HTTP
     * status, error type, exception class, and message. The response is returned with an
     * HTTP 500 Internal Server Error status.
     *
     * @param e the {@link Exception} instance that was thrown during request processing
     * @return a {@link ResponseEntity} containing an {@link ErrorDTO} object with error details
     *         and an HTTP status code of 500 (Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> exceptionHandler(Exception e) {
        LOGGER.warn("Internal server error: {}", e.getMessage());
        ErrorDTO error = new ErrorDTO();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + " Error");
        error.setException(e.getClass().getName());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }
}
