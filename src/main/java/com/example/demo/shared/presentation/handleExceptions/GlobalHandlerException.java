package com.example.demo.shared.presentation.handleExceptions;

import com.example.demo.shared.application.exceptions.ExistingResourceException;
import com.example.demo.shared.application.exceptions.NotFoundException;
import com.example.demo.shared.application.exceptions.generics.ResourceFail;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalHandlerException {
    private final FieldErrorMapper fieldErrorMapper;
    @Autowired
    public GlobalHandlerException(FieldErrorMapper fieldErrorMapper) {
        this.fieldErrorMapper = fieldErrorMapper;
    }

    @ExceptionHandler(ExistingResourceException.class)
    public ResponseEntity<ResponseException> handle(ExistingResourceException e, HttpServletRequest req){
        HttpStatus status = HttpStatus.CONFLICT;
        ResponseException response = ResponseException
                .create(status, e.getResourceFails(), req.getServletPath());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseException> handle(NotFoundException e, HttpServletRequest req){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ResponseException response = ResponseException
                .create(status, e.getResourceFails(), req.getServletPath());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseException> handle(MethodArgumentNotValidException e, HttpServletRequest req){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<ResourceFail> errors = e.getFieldErrors().stream()
                .map(fieldErrorMapper::toResourceFail)
                .toList();
        ResponseException response = ResponseException
                .create(status, errors, req.getServletPath());
        return new ResponseEntity<>(response, status);
    }
}
