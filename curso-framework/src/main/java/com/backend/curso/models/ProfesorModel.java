package com.backend.curso.models;

import com.backend.curso.entities.Profesor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProfesorModel {
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo o vacio")
    private String nombre;

    @NotNull(message = "El apellido paterno no puede ser nulo o vacio")
    @NotEmpty
    private String apellidoPaterno;

    @NotNull(message = "El apellido paterno no puede ser nulo o vacio")
    private String apellidoMaterno;

    @NotNull(message = "La CURP no puede ser nulo o vacio")
    @Size(min = 16, max = 20)
    private String curp;

    public ProfesorModel(Profesor profesor) {
        this.id = profesor.getId();
        this.nombre = profesor.getNombre();
        this.apellidoPaterno = profesor.getApellidoPaterno();
        this.apellidoMaterno = profesor.getApellidoMaterno();
        this.curp = profesor.getCurp();
    }

}
