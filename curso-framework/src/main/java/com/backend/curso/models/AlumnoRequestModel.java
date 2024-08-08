package com.backend.curso.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoRequestModel {
    @NotNull(message = "El nombre no puede ser nulo o vacio")
    private String nombre;
    @NotNull(message = "El apellido paterno no puede ser nulo o vacio")
    @NotEmpty
    private String apellidoPaterno;
    @NotNull(message = "El apellido paterno no puede ser nulo o vacio")
    private String apellidoMaterno;  
    private String numeroControl;
    @NotNull(message = "La CURP no puede ser nulo o vacio")    
    @Size(min = 16, max = 20)
    private String curp;    
}

