package com.backend.curso.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.curso.models.AlumnoModel;
import com.backend.curso.models.ClaseModel;
import com.backend.curso.services.ClasesService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clases")
public class ClasesController {
    private final ClasesService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClaseModel> obtenerPorId(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(service.obtenerModelPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClaseModel> guardar(@Valid @RequestBody ClaseModel model) {
        return ResponseEntity.status(201).body(service.guardarModel(model));
    }

    @PostMapping("/{id}/alumnos")
    public ResponseEntity<AlumnoModel> guardar(@PathVariable("id") long id,
                                               @RequestBody AlumnoModel model) {
        return ResponseEntity.status(201).body(service.guardarAlumnoModel(id, model));
    }

    @DeleteMapping("/{id}/alumnos/{idAlumno}")
    public ResponseEntity<Void> guardar(@PathVariable("id") long id,
                                        @PathVariable("idAlumno") long idAlumno) {
        service.quitarAlumno(id, idAlumno);
        return ResponseEntity.ok().build();
    }
}
