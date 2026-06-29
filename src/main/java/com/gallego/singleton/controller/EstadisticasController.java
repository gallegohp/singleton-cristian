package com.gallego.singleton.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallego.singleton.services.EstadisticasService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {
    
    private final EstadisticasService estadisticasService;
    
    public EstadisticasController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
        System.out.println("🔴 EstadisticasController creado - Servicio inyectado: " + estadisticasService.hashCode());
    }
    
    // Endpoint que devuelve todas las estadísticas en formato JSON
    @GetMapping
    public Map<String, Object> obtenerEstadisticas() {
        Map<String, Object> estadisticas = new HashMap<>();
        estadisticas.put("totalAprendices", estadisticasService.getTotalAprendices());
        estadisticas.put("totalInstructores", estadisticasService.getTotalInstructores());
        estadisticas.put("totalProgramas", estadisticasService.getTotalProgramas());
        estadisticas.put("totalGeneral", estadisticasService.getTotalGeneral());
        estadisticas.put("hashCodeServicio", estadisticasService.hashCode());
        estadisticas.put("mensaje", "✅ Todas las estadísticas comparten la misma instancia");
        return estadisticas;
    }
    
    // Endpoint para reiniciar estadísticas (opcional)
    @GetMapping("/reiniciar")
    public String reiniciarEstadisticas() {
        estadisticasService.reiniciarEstadisticas();
        return "🔄 Estadísticas reiniciadas exitosamente";
    }
}