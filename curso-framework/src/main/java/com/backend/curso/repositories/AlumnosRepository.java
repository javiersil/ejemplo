
package com.backend.curso.repositories;

import com.backend.curso.entities.Alumno;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface AlumnosRepository extends JpaRepository<Alumno, Long> {

   public Page<Alumno> findAll(Specification<Alumno> filtros, Pageable pagina);
   // public Optional<Alumno> findByCurpNoId(String curp, long id);    
   public Optional<Alumno> findByCurp(String curp);
   //@Query("SELECT a FROM Alumno a  WHERE a.nombre = :nombre")
   public Optional<Alumno> findByNombre(String nombre);
   public List<Alumno> findByNumeroControl(String numeroControl);
}
