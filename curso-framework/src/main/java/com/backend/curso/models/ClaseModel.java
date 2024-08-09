package com.backend.curso.models;

import com.backend.curso.entities.Clase;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClaseModel {
    private Long id;
    @NotNull(message = "La descripcion no puede ser nulo o vacio")
    private String descripcion;
    
    @NotNull(message = "El profesor no puede ser nulo o vacio")
    private ProfesorModel profesor;

    public ClaseModel(Clase clase) {
        this.id = clase.getId();
        this.descripcion =  clase.getDescripcion();
        this.profesor = new ProfesorModel(clase.getProfesor());
    }
}
