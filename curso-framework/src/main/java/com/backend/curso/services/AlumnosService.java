/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.curso.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.curso.entities.Alumno;
import com.backend.curso.models.AlumnoRequestModel;
import com.backend.curso.models.AlumnoResponseModel;
import com.backend.curso.repositories.AlumnosRepository;
/**
 *
 * @author Marcos
 */
@Service
public class AlumnosService {
    private final AlumnosRepository repository;
    
    public AlumnosService(AlumnosRepository repository) {
       this.repository = repository;
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

    public void eliminar(long id) throws Exception {
        Alumno alumno = obtenerPorId(id);
        repository.delete(alumno);
    }
}
