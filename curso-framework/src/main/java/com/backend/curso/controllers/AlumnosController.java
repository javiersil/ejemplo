
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

import com.backend.curso.models.AlumnoModel;
import com.backend.curso.services.AlumnosService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

//   /alumnos?curp=123123
/**
 * Response
 * Request
 * 
 * @author Marcos
 */
@AllArgsConstructor
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
  private final AlumnosService service;

  @GetMapping
  public ResponseEntity<Page<AlumnoModel>> obtenerTodos(
      @RequestParam(name = "pagina", defaultValue = "0", required = false) int pagina,
      @RequestParam(name = "cantidad", defaultValue = "50", required = false) int cantidad,
      @RequestParam(name = "numero-control", defaultValue = "", required = false) String numeroControl,
      @RequestParam(name = "curp", defaultValue = "", required = false) String curp) {
    return ResponseEntity.ok(service.obtenerTodos(numeroControl, curp, pagina, cantidad));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AlumnoModel> obtenerPorId(@PathVariable("id") long id) {
    return ResponseEntity.ok(service.obtenerModelPorId(id));
  }

  @PostMapping
  public ResponseEntity<AlumnoModel> guardar(@Valid @RequestBody AlumnoModel model) {
    return ResponseEntity.status(201).body(service.guardarModel(model));
  }

  @PutMapping("/{id}")
  public ResponseEntity<AlumnoModel> editar(
      @PathVariable("id") long id,
      @Valid @RequestBody AlumnoModel model) {
    return ResponseEntity.ok().body(service.editarModel(id, model));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable("id") long id) {
    service.eliminar(id);
    return ResponseEntity.ok().build();
  }

}
