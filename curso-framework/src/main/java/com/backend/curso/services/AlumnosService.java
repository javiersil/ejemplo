package com.backend.curso.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.backend.curso.entities.Alumno;
import com.backend.curso.exceptions.ConflictException;
import com.backend.curso.exceptions.NoContentException;
import com.backend.curso.models.AlumnoModel;
import com.backend.curso.repositories.AlumnosRepository;

import jakarta.persistence.criteria.Predicate;
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

    public Alumno obtenerPorId(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoContentException());
    }

    public Alumno guardar(Alumno alumno) {
        log.info("Guardar");
        if (repository.findByCurp(alumno.getCurp()).isPresent()) {
            log.warn("No se pudo guardar por la curp: " + alumno.getCurp());
            throw new ConflictException("No puedes guardar un alumno con esa curp");
        }
        return repository.save(alumno);
    }

    public Alumno editar(long id, AlumnoModel model) {
        Alumno alumno = obtenerPorId(id);
        Alumno alumnoEncontrado = repository.findByCurp(alumno.getCurp()).orElse(null);
        if (alumnoEncontrado != null && alumnoEncontrado.getId() != id) {
            throw new ConflictException("No puedes editar un alumno con esa curp");
        }
        alumno.setApellidoMaterno(model.getApellidoMaterno());
        alumno.setApellidoPaterno(model.getApellidoPaterno());
        alumno.setCurp(model.getCurp());
        alumno.setNombre(model.getNombre());
        return repository.save(alumno);
    }

    public void eliminar(long id) {
        Alumno alumno = obtenerPorId(id);
        repository.delete(alumno);
    }

    public Page<AlumnoModel> obtenerTodos(String numeroControl,
                                         String curp,
                                         int pagina,
                                         int cantidad) {
        return repository.findAll(consulta(numeroControl, curp), PageRequest.of(pagina, cantidad))
                .map(AlumnoModel::new);
    }

    public AlumnoModel obtenerModelPorId(long id) {
        return new AlumnoModel(obtenerPorId(id));
    }

    public AlumnoModel guardarModel(AlumnoModel model) {
        return new AlumnoModel(guardar(new Alumno(model)));
    }

    public AlumnoModel editarModel(long id, AlumnoModel model) {
        return new AlumnoModel(editar(id, model));
    }

    private Specification<Alumno> consulta(String numeroControl, String curp) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if (numeroControl != null && !numeroControl.equals("")) {
                predicados.add(criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("numeroControl"), numeroControl)));
            }
            if (curp != null && !curp.equals("")) {
                predicados.add(criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("curp"), curp)));
            }
            return criteriaBuilder.and(predicados.toArray(new Predicate[0]));
        };
    }
}
