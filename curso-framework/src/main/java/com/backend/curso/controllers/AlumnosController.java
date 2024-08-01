
package com.backend.curso.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String saludo() {
      return "Hola";
    }
    
    @GetMapping("/{id}")
    public AlumnoResponseModel obtenerPorId(@PathVariable("id") long id) throws Exception {
      return service.obtenerModelPorId(id);
    }
    
    public AlumnoResponseModel guardar(AlumnoRequestModel model) throws Exception {
       return service.guardarModel(model);
    }
    
}
