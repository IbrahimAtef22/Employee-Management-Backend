package com.jobhacker.springboot.employeeapp.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{

    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
