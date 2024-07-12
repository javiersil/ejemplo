/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banckend.curso.controllers;

import com.banckend.curso.models.AlumnoRequestModel;
import com.banckend.curso.models.AlumnoResponseModel;
import com.banckend.curso.services.AlumnosService;

/**
 *  Response
 *  Request
 * @author Marcos
 */
public class AlumnosController {
    private final AlumnosService service;
    
    public AlumnosController() {
       this.service = new AlumnosService();
    }
    
    public AlumnoResponseModel obtenerPorId(long id) throws Exception {
      return service.obtenerModelPorId(id);
    }
    
    public AlumnoResponseModel guardar(AlumnoRequestModel model) throws Exception {
       return service.guardarModel(model);
    }
    
}
