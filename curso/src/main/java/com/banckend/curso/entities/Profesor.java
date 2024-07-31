package com.banckend.curso.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
@SequenceGenerator(name = "profesor_seq", allocationSize = 1 )
@NamedQueries({
    @NamedQuery(name = "Profesor.findById", query= "SELECT a FROM Profesor a  WHERE a.id = :id "),
    @NamedQuery(name = "Profesor.findByCurp", query= "SELECT a FROM Profesor a  WHERE a.curp = :curp ")
})
public class Profesor implements Serializable {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq" )
    private Long id;
    @Column(name= "nombre", length=35, nullable = false )
    private String nombre;
    @Column(name= "apellido_paterno", length=40, nullable = false )
    private String apellidoPaterno;
    @Column(name= "apellido_materno", length=40, nullable = false )
    private String apellidoMaterno;   
    @Column(name= "curp", length=20, nullable = false )
    private String curp;
    
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


    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    
}
