
package com.backend.curso.controllers;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.curso.models.AlumnoRequestModel;
import com.backend.curso.models.AlumnoResponseModel;
import com.backend.curso.services.AlumnosService;

/**
 *  Response
 *  Request
 * @author Marcos
 */
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
    private final AlumnosService service;
    
    public AlumnosController(AlumnosService service) {
       this.service = service;
    }

    @GetMapping
    public String saludo( @RequestParam(name = "bloqueado", defaultValue = "false", required = false ) boolean bloqueado) {
      return "Hola";
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseModel> obtenerPorId(@PathVariable("id") long id) throws Exception {
      return ResponseEntity.ok(service.obtenerModelPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<AlumnoResponseModel> guardar(@RequestBody AlumnoRequestModel model) throws Exception {
       return  ResponseEntity.status(201).body(service.guardarModel(model));
    }
    
}
