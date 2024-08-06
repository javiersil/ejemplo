
package com.backend.curso.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.curso.models.AlumnoRequestModel;
import com.backend.curso.models.AlumnoResponseModel;
import com.backend.curso.services.AlumnosService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

/**
 *  Response
 *  Request
 * @author Marcos
 */
@AllArgsConstructor
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
    private final AlumnosService service;  

    @GetMapping
    public ResponseEntity<List<AlumnoResponseModel>> saludo() {
      return  ResponseEntity.ok(service.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseModel> obtenerPorId(@PathVariable("id") long id) {
      return ResponseEntity.ok(service.obtenerModelPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<AlumnoResponseModel> guardar(@Valid @RequestBody AlumnoRequestModel model) {
       return  ResponseEntity.status(201).body(service.guardarModel(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseModel> editar(@PathVariable("id") long id,
                                                      @RequestBody AlumnoRequestModel model) {
       return  ResponseEntity.status(200).body(service.editarModel(id, model));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
        service.eliminar(id);
        return  ResponseEntity.ok().build();
    }
}
