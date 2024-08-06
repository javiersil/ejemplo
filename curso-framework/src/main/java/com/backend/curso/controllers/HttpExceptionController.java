package com.backend.curso.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.backend.curso.exceptions.ConflictException;
import com.backend.curso.exceptions.NoContentException;

@ControllerAdvice
public class HttpExceptionController  {
    @ResponseBody
    @ExceptionHandler(NoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> notFoundHandler(NoContentException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("error", ex.getMessage());
        return errors;
    }

    @ResponseBody
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> conflictHandler(ConflictException ex) {
        Map<String, Object> errors = new HashMap<String, Object>();
        if (ex.getListError() != null && ex.getListError().size() > 0) {
            errors.put("errors", ex.getListError());
        } else {
            errors.put("error", ex.getMessage());
        }
        return errors;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, Object> conflictHandler(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<String, Object>();
            errors.put("errors", ex.getAllErrors());
        return errors;
    }
    
}
