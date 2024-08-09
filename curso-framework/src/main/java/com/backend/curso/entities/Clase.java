package com.backend.curso.entities;

import java.util.List;

import com.backend.curso.models.ClaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
/*
 * OneToOne
 * OneToMany
 * ManyToOne
 * ManyToMany
 */
@Getter
@Entity
@Table(name = "clase")
@SequenceGenerator(name = "clase_seq", allocationSize = 1)
public class Clase {
  
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clase_seq")
    private Long id;

    @Column(name = "descripcion", length = 50, nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    @OneToMany    
    private List<Alumno> alumnos;

    public Clase(ClaseModel model, Profesor profesor) {
        this.descripcion =  model.getDescripcion();
        this.profesor = profesor;
    }

}
