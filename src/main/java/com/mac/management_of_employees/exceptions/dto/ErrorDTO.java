package com.mac.management_of_employees.exceptions.dto;

import java.util.Date;

/**
 * A Data Transfer Object class for capturing error details in a structured manner.
 * This class is commonly used for conveying error information, such as during
 * exception handling in web applications.
 * Fields:
 * - timestamp: The exact date and time when the error occurred.
 * - status: The HTTP status code associated with the error.
 * - error: A simple error description or error type.
 * - exception: The class name of the exception that caused the error.
 * - message: A detailed error message providing additional context about the error.
 */
public class ErrorDTO {

    /**
     * Represents the exact date and time when the error occurred.
     */
    private Date timestamp;

    /**
     * Represents the HTTP status code associated with an error.
     */
    private int status;

    /**
     * A brief description or type of the error.
     */
    private String error;

    /**
     * Holds the class name of the exception that caused the error.
     */
    private String exception;

    /**
     * Provides a detailed error message offering additional context about the error.
     */
    private String message;

    /**
     * Retrieves the timestamp indicating the exact date and time when an error occurred.
     *
     * @return the timestamp of the error represented as a Date object.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp indicating the exact date and time when the error occurred.
     *
     * @param timestamp the date and time of the error, represented as a Date object
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Retrieves the HTTP status code associated with an error.
     *
     * @return the HTTP status code represented as an integer.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code associated with an error.
     *
     * @param status the HTTP status code represented as an integer
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Retrieves the error description or type of the error.
     *
     * @return the error description as a String.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error description or type of the error.
     *
     * @param error the error description as a String
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Retrieves the class name of the exception that caused the error.
     *
     * @return the class name of the exception as a String.
     */
    public String getException() {
        return exception;
    }

    /**
     * Sets the class name of the exception that caused the error.
     *
     * @param exception the class name of the exception as a String
     */
    public void setException(String exception) {
        this.exception = exception;
    }

    /**
     * Retrieves the detailed message associated with the error.
     *
     * @return the error message as a String.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the detailed message associated with the error.
     *
     * @param message the error message as a String
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
