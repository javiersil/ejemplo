package com.backend.curso.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.curso.models.ClaseModel;
import com.backend.curso.services.ClasesService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clases")
public class ClasesController {
    private final ClasesService service;

    @PostMapping
    public ResponseEntity<ClaseModel> guardar(@Valid @RequestBody ClaseModel model) {
        return ResponseEntity.status(201).body(service.guardarModel(model));
    }
}
