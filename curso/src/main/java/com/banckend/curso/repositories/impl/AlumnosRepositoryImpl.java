/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banckend.curso.repositories.impl;

import com.banckend.curso.entities.Alumno;
import com.banckend.curso.repositories.AlumnosRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcos
 */
public class AlumnosRepositoryImpl implements AlumnosRepository {

    private final EntityManagerFactory manager;
    
    private List<Alumno> alumnos = new ArrayList();
    
    public AlumnosRepositoryImpl(){
        manager = Persistence
                .createEntityManagerFactory("com.banckend_curso_jar_1.0.0PU");
    }
    
    @Override
    public Optional<Alumno> findById(long id) {
        return alumnos.stream().filter( alumno -> alumno.getId() == id)
                .findFirst();
    }

    @Override
    public Alumno save(Alumno alumno) {
        alumno.setId(Long.parseLong((alumnos.size() + 1) + ""));
        alumnos.add(alumno);
        return alumno;
    }

    @Override
    public Alumno update(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); 
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); 
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public  Optional<Alumno> findByCurp(String curp) {
        return alumnos.stream().filter( alumno -> alumno.getCurp().equals(curp))
                .findFirst();
    }
    
}
