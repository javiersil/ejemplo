package com.backend.curso.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.curso.entities.Profesor;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesor, Long> {    
   public Page<Profesor> findAll(Specification<Profesor> filtros, Pageable pagina);
   public Optional<Profesor> findByCurp(String curp);
}
