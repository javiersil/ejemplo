package com.backend.curso.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.curso.models.ProfesorModel;
import com.backend.curso.services.ProfesoresService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/profesores")
public class ProfesoresController {
    private final ProfesoresService service;

    @GetMapping
    public ResponseEntity<Page<ProfesorModel>> obtenerTodos(
            @RequestParam(name = "pagina", defaultValue = "0", required = false) int pagina,
            @RequestParam(name = "cantidad", defaultValue = "50", required = false) int cantidad,
            @RequestParam(name = "curp", defaultValue = "", required = false) String curp) {
        return ResponseEntity.ok(service.obtenerTodos(curp, pagina, cantidad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorModel> obtenerPorId(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.obtenerModelPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProfesorModel> guardar(@Valid @RequestBody ProfesorModel model) {
        return ResponseEntity.status(201).body(service.guardarModel(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorModel> editar(
            @PathVariable("id") long id,
            @RequestBody ProfesorModel model) {
        return ResponseEntity.ok().body(service.editarModel(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
