package com.backend.curso.models;

import java.util.List;
import java.util.stream.Collectors;

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

    private List<AlumnoModel> alumnos;

    public ClaseModel(Clase clase) {
        this.id = clase.getId();
        this.descripcion =  clase.getDescripcion();
        this.profesor = new ProfesorModel(clase.getProfesor());
        this.alumnos =  clase.getAlumnos().stream()
                             .map(AlumnoModel::new).collect(Collectors.toList());
    }
}
