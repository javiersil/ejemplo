package com.backend.curso.models;

import com.backend.curso.entities.Alumno;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AlumnoModel {   
    private Long id;

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

      public AlumnoModel(Alumno alumno) {
         this.id = alumno.getId();
         this.nombre = alumno.getNombre();
         this.apellidoPaterno = alumno.getApellidoPaterno();
         this.apellidoMaterno = alumno.getApellidoMaterno();
         this.curp = alumno.getCurp();
         this.numeroControl = alumno.getNumeroControl();
    }
}

