package com.gallego.singleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallego.singleton.services.EstadisticasService;

@RestController
@RequestMapping("/programas")
public class ProgramaController {
    
    private final EstadisticasService estadisticasService;
    
    public ProgramaController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
        System.out.println("ProgramaController creado - Servicio inyectado: " + estadisticasService.hashCode());
    }
    
    @GetMapping
    public String listarProgramas() {
        estadisticasService.incrementarProgramas();
        return "Listado de programas - Consulta registrada";
    }
}