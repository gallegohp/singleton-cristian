package com.gallego.singleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallego.singleton.services.EstadisticasService;

@RestController
@RequestMapping("/instructores")
public class InstructorController {
    
    private final EstadisticasService estadisticasService;
    
    public InstructorController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
        System.out.println("InstructorController creado - Servicio inyectado: " + estadisticasService.hashCode());
    }
    
    @GetMapping
    public String listarInstructores() {
        estadisticasService.incrementarInstructores();
        return "Listado de instructores - Consulta registrada";
    }
}