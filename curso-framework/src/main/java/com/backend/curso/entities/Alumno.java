
package com.backend.curso.entities;

import com.backend.curso.models.AlumnoRequestModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "alumno")
@SequenceGenerator(name = "alumno_seq", allocationSize = 1 )
public class Alumno implements Serializable {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_seq" )
    private Long id;
    @Column(name= "nombre", length=35, nullable = false )
    private String nombre;
    @Column(name= "apellido_paterno", length=40, nullable = false )
    private String apellidoPaterno;
    @Column(name= "apellido_materno", length=40, nullable = false )
    private String apellidoMaterno;
    @Column(name= "numero_control", length=15, nullable = false )
    private String numeroControl;    
    @Column(name= "curp", length=20, nullable = false )
    private String curp;

    public Alumno() {}
    
    public Alumno(AlumnoRequestModel model) {
       this.nombre = model.getNombre();
       this.apellidoPaterno = model.getApellidoPaterno();
       this.apellidoMaterno = model.getApellidoMaterno();
       this.curp = model.getCurp();
       this.numeroControl = model.getNumeroControl() + "3333";
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    
    
}
