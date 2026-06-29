package com.gallego.singleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallego.singleton.services.EstadisticasService;

@RestController
@RequestMapping("/aprendices")
public class AprendizController {
    
    private final EstadisticasService estadisticasService;
    
    // Inyección de dependencia - Spring inyecta la MISMA instancia
    public AprendizController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
        System.out.println("AprendizController creado - Servicio inyectado: " + estadisticasService.hashCode());
    }
    
    @GetMapping
    public String listarAprendices() {
        estadisticasService.incrementarAprendices();
        return "Listado de aprendices - Consulta registrada";
    }
}