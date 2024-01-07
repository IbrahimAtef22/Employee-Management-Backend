package com.jobhacker.springboot.employeeapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> employeeNotFound(EmployeeNotFoundException ex){
        EmployeeException employeeException = new EmployeeException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(employeeException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<Object> employeeAlreadyExists(EmployeeAlreadyExistsException ex){
        EmployeeException employeeException = new EmployeeException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(employeeException, HttpStatus.CONFLICT);
    }
}
