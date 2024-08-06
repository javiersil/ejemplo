package com.backend.curso.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.curso.entities.Alumno;
import com.backend.curso.exceptions.ConflictException;
import com.backend.curso.exceptions.NoContentException;
import com.backend.curso.models.AlumnoRequestModel;
import com.backend.curso.models.AlumnoResponseModel;
import com.backend.curso.repositories.AlumnosRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author Marcos
 */
@Log4j2
@AllArgsConstructor
@Service
public class AlumnosService {
    private final AlumnosRepository repository;

    public Alumno guardar(Alumno alumno) {
        log.info("Guardar");
        if (repository.findByCurp(alumno.getCurp()).isPresent()) {
            log.warn("No se pudo guardar por la curp: " + alumno.getCurp());
            throw new ConflictException("No puedes guardar un alumno con esa curp");
        }

        return repository.save(alumno);
    }

    public Alumno obtenerPorId(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoContentException());
    }

    public AlumnoResponseModel obtenerModelPorId(long id) {
        return new AlumnoResponseModel(obtenerPorId(id));
    }

    public AlumnoResponseModel guardarModel(AlumnoRequestModel model) {
        return new AlumnoResponseModel(guardar(new Alumno(model)));
    }

    public void eliminar(long id) {
        Alumno alumno = obtenerPorId(id);
        repository.delete(alumno);
    }

    public List<AlumnoResponseModel> obtenerTodos() {
        log.info("Obtiene todos");
        List<AlumnoResponseModel> modelos = new ArrayList();
        for (Alumno alumno : repository.findAll()) {
            modelos.add(new AlumnoResponseModel(alumno));
        }
        return modelos;
    }

    public Alumno editar(long id, AlumnoRequestModel model)  {
        Alumno alumno = obtenerPorId(id);
        Alumno alumnoEncontrado = repository.findByCurp(alumno.getCurp()).orElse(null);
        if (alumnoEncontrado != null && alumnoEncontrado.getId() != id) {
            throw new ConflictException("No puedes guardar un alumno con esa curp");
        }
        alumno.setApellidoMaterno(model.getApellidoMaterno());
        alumno.setApellidoPaterno(model.getApellidoPaterno());
        alumno.setCurp(model.getCurp());
        alumno.setNombre(model.getNombre());
       return repository.save(alumno);
    }


    public AlumnoResponseModel editarModel(long id, AlumnoRequestModel model) {
        return new AlumnoResponseModel(editar(id, model));
    }
}
