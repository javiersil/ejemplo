package com.backend.curso.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class Persona {
    @Column(name = "nombre", length = 35, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 40, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 40, nullable = false)
    private String apellidoMaterno;
   
    @Column(name = "curp", length = 20, nullable = false)
    private String curp;
}
