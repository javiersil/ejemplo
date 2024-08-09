package com.backend.curso.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.backend.curso.entities.Profesor;
import com.backend.curso.exceptions.ConflictException;
import com.backend.curso.exceptions.NoContentException;
import com.backend.curso.models.ProfesorModel;
import com.backend.curso.repositories.ProfesoresRepository;

import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Service
public class ProfesoresService {
    private final ProfesoresRepository repository;

    public Profesor obtenerPorId(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoContentException());
    }

    public Profesor guardar(Profesor profesor) {
        log.info("Guardar");
        if (repository.findByCurp(profesor.getCurp()).isPresent()) {
            log.warn("No se pudo guardar por la curp: " + profesor.getCurp());
            throw new ConflictException("No puedes guardar un profesor con esa curp");
        }
        return repository.save(profesor);
    }

    public Profesor editar(long id, ProfesorModel model) {
        Profesor profesor = obtenerPorId(id);
        Profesor profesorEncontrado = repository.findByCurp(profesor.getCurp()).orElse(null);
        if (profesorEncontrado != null && profesorEncontrado.getId() != id) {
            throw new ConflictException("No puedes editar un profesor con esa curp");
        }
        profesor.setApellidoMaterno(model.getApellidoMaterno());
        profesor.setApellidoPaterno(model.getApellidoPaterno());
        profesor.setCurp(model.getCurp());
        profesor.setNombre(model.getNombre());
        return repository.save(profesor);
    }

    public void eliminar(long id) {
        Profesor profesor = obtenerPorId(id);
        repository.delete(profesor);
    }

    public Page<ProfesorModel> obtenerTodos(String curp,
            int pagina,
            int cantidad) {
        return repository.findAll(consulta(curp), PageRequest.of(pagina, cantidad))
                .map(ProfesorModel::new);
    }

    public ProfesorModel obtenerModelPorId(long id) {
        return new ProfesorModel(obtenerPorId(id));
    }

    public ProfesorModel guardarModel(ProfesorModel model) {
        return new ProfesorModel(guardar(new Profesor(model)));
    }

    public ProfesorModel editarModel(long id, ProfesorModel model) {
        return new ProfesorModel(editar(id, model));
    }

    private Specification<Profesor> consulta(String curp) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicados = new ArrayList<>();
            if (curp != null && !curp.equals("")) {
                predicados.add(criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("curp"), curp)));
            }
            return criteriaBuilder.and(predicados.toArray(new Predicate[0]));
        };
    }
}
