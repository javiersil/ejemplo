/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banckend.curso.services;

import com.banckend.curso.entities.Alumno;
import com.banckend.curso.models.AlumnoRequestModel;
import com.banckend.curso.models.AlumnoResponseModel;
import com.banckend.curso.repositories.AlumnosRepository;
import com.banckend.curso.repositories.impl.AlumnosRepositoryImpl;

/**
 *
 * @author Marcos
 */
public class AlumnosService {
    private final AlumnosRepository repository;
    
    public AlumnosService() {
       this.repository = new AlumnosRepositoryImpl();
    }
    
    public Alumno guardar(Alumno alumno) throws Exception {   
        System.out.println("Que pasa aqui");
        if(repository.findByCurp(alumno.getCurp()).isPresent()) {
          throw new Exception("No puedes guardar un alumno con esa curp");
        }   
        
       return repository.save(alumno);
    }
    
    public Alumno obtenerPorId(long id) throws Exception {        
       return repository.findById(id)
               .orElseThrow(() -> new Exception("El alumno no se encuentra"));
    }

    public AlumnoResponseModel obtenerModelPorId(long id) throws Exception {
        return new AlumnoResponseModel(obtenerPorId(id));
    }

    public AlumnoResponseModel guardarModel(AlumnoRequestModel model) throws Exception {
        return new AlumnoResponseModel(guardar(new Alumno(model)));
    }
}
