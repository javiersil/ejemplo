/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.curso.repositories;

import com.backend.curso.entities.Alumno;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface AlumnosRepository extends CrudRepository<Alumno, Long> {
   // public Optional<Alumno> findByCurpNoId(String curp, long id);    
    public Optional<Alumno> findByCurp(String curp);
   //@Query("SELECT a FROM Alumno a  WHERE a.nombre = :nombre")
   public Optional<Alumno> findByNombre(String nombre);
}
