package com.backend.curso.services;

import org.springframework.stereotype.Service;

import com.backend.curso.entities.Clase;
import com.backend.curso.entities.Profesor;
import com.backend.curso.exceptions.NoContentException;
import com.backend.curso.models.ClaseModel;
import com.backend.curso.repositories.ClasesRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClasesService {
    private final ClasesRepository repository;
    private final ProfesoresService profesoresService;

    public Clase obtenerPorId(long id) {
        return repository.findById(id).orElseThrow(() -> new NoContentException() );
    }

    public Clase guardar(Clase clase) {
        return repository.save(clase);
    }

    public ClaseModel guardarModel(ClaseModel model) {
        Profesor profesor = profesoresService.obtenerPorId(model.getProfesor().getId());
        Clase clase  =  new Clase(model, profesor);
        return new ClaseModel(guardar(clase));
    }
}
