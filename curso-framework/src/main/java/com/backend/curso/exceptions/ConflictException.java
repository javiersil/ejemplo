package com.backend.curso.exceptions;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ConflictException  extends RuntimeException{
   
	private static final long serialVersionUID = 1L;
	private List<ObjectError> listError;
    public ConflictException(){
        super("Ocurrio un error");
    }
    public ConflictException(String error){
        super(error);
    }
    public ConflictException(List<ObjectError> _listError){
        super("Ocurrio un error");
        this.listError= _listError;
    }
    public List<ObjectError> getListError(){
        return this.listError;
    }
}
