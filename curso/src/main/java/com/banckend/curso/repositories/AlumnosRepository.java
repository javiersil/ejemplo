/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.banckend.curso.repositories;

import com.banckend.curso.entities.Alumno;
import java.util.Optional;

/**
 *
 * Create
 * Read
 * Update
 * Delete
 * 
 * 
 * CRUD
 * 
 * @author Marcos
 */
public interface AlumnosRepository {
    public Optional<Alumno> findById(long id);
    public Alumno save(Alumno alumno);
    public Alumno update(Alumno alumno);
    public void delete(Alumno alumno);
    
    public Optional<Alumno> findByCurp(String curp);
}
