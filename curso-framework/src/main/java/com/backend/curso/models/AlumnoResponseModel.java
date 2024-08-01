
package com.backend.curso.models;

import com.backend.curso.entities.Alumno;

/**
 *
 * @author Marcos
 */
public class AlumnoResponseModel {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroControl;    
    private String curp;
    
    public AlumnoResponseModel(Alumno alumno) {
         this.id = alumno.getId();
         this.nombre = alumno.getNombre();
         this.apellidoPaterno = alumno.getApellidoPaterno();
         this.apellidoMaterno = alumno.getApellidoMaterno();
         this.curp = alumno.getCurp();
         this.numeroControl = alumno.getNumeroControl();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public String getCurp() {
        return curp;
    }

    
}
