package com.backend.curso.entities;

import java.util.List;

import com.backend.curso.models.ClaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * OneToOne
 * OneToMany
 * ManyToOne
 * ManyToMany
 */
@NoArgsConstructor
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
    @JoinColumn(name = "id_rofesor", nullable = false)
    private Profesor profesor;

    @Setter
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clase_alumno", joinColumns = {
            @JoinColumn(referencedColumnName = "id", name = "id_clase", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(referencedColumnName = "id", name = "id_alumno", nullable = false )
    }) 
    private List<Alumno> alumnos;

    public Clase(ClaseModel model, Profesor profesor) {
        this.descripcion = model.getDescripcion();
        this.profesor = profesor;
    }

}
