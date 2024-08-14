package com.backend.curso.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.backend.curso.entities.Alumno;
import com.backend.curso.entities.Clase;
import com.backend.curso.entities.Profesor;
import com.backend.curso.exceptions.NoContentException;
import com.backend.curso.models.AlumnoModel;
import com.backend.curso.models.ClaseModel;
import com.backend.curso.repositories.ClasesRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClasesService {
    private final ClasesRepository repository;
    private final ProfesoresService profesoresService;
    private final AlumnosService alumnosService;

    public Clase obtenerPorId(long id) {
        return repository.findById(id).orElseThrow(() -> new NoContentException() );
    }

    public ClaseModel obtenerModelPorId(long id) {
        return new ClaseModel(obtenerPorId(id));
    }

    public Clase guardar(Clase clase) {
        return repository.save(clase);
    }

    public ClaseModel guardarModel(ClaseModel model) {
        Profesor profesor = profesoresService.obtenerPorId(model.getProfesor().getId());        
        Clase clase  =  new Clase(model, profesor);
        return new ClaseModel(guardar(clase));
    }

    public AlumnoModel guardarAlumnoModel(long id, AlumnoModel model) {
        Clase clase = obtenerPorId(id);
        Alumno alumno = alumnosService.obtenerPorId(model.getId());
        clase.getAlumnos().add(alumno);
        guardar(clase);
        return model;
    }

    public void quitarAlumno(long id, long idAlumno) {
        Clase clase = obtenerPorId(id);
         List<Alumno> alumnos = clase.getAlumnos()
         .stream()
         .filter(alumno -> !alumno.getId().equals(idAlumno))
         .collect(Collectors.toList());

         clase.setAlumnos(alumnos);
        guardar(clase);
    }
}
