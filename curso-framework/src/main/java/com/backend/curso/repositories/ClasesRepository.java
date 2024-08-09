package com.backend.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.curso.entities.Clase;


@Repository
public interface ClasesRepository extends JpaRepository<Clase, Long> {    
}
