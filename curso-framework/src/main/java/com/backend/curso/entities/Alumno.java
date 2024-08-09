
package com.backend.curso.entities;

import com.backend.curso.models.AlumnoModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "alumno")
@SequenceGenerator(name = "alumno_seq", allocationSize = 1)
public class Alumno extends Persona implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_seq")
    private Long id;

    @Column(name = "numero_control", length = 15, nullable = false)
    private String numeroControl;
    

    public Alumno(AlumnoModel model) {
        this.setNombre(model.getNombre());
        this.setApellidoPaterno(model.getApellidoPaterno());
        this.setApellidoMaterno(model.getApellidoMaterno());
        this.setCurp(model.getCurp());
        this.numeroControl = model.getNumeroControl();
    }
}
