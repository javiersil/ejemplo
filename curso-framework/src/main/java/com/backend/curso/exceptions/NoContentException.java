package com.backend.curso.exceptions;

public class NoContentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoContentException(){
        super("El recurso solicidato no fue encontrado");
    }
}
