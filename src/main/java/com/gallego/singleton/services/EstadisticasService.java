package com.gallego.singleton.services;

import org.springframework.stereotype.Service;

@Service
public class EstadisticasService {
    
    // Contadores para cada tipo de consulta
    private int totalConsultasAprendices = 0;
    private int totalConsultasInstructores = 0;
    private int totalConsultasProgramas = 0;
    private int totalGeneral = 0;
    
    // Constructor - Spring solo lo ejecutará UNA VEZ
    public EstadisticasService() {
        System.out.println("INSTANCIA CREADA - HashCode: " + this.hashCode());
        System.out.println("Servicio de estadísticas inicializado");
    }
    
    // Métodos para incrementar contadores
    public void incrementarAprendices() {
        totalConsultasAprendices++;
        totalGeneral++;
        System.out.println("Consulta de aprendiz #" + totalConsultasAprendices);
    }
    
    public void incrementarInstructores() {
        totalConsultasInstructores++;
        totalGeneral++;
        System.out.println("Consulta de instructor #" + totalConsultasInstructores);
    }
    
    public void incrementarProgramas() {
        totalConsultasProgramas++;
        totalGeneral++;
        System.out.println("Consulta de programa #" + totalConsultasProgramas);
    }
    
    // Métodos para obtener estadísticas
    public int getTotalAprendices() {
        return totalConsultasAprendices;
    }
    
    public int getTotalInstructores() {
        return totalConsultasInstructores;
    }
    
    public int getTotalProgramas() {
        return totalConsultasProgramas;
    }
    
    public int getTotalGeneral() {
        return totalGeneral;
    }
    
    // Método para reiniciar estadísticas (opcional)
    public void reiniciarEstadisticas() {
        totalConsultasAprendices = 0;
        totalConsultasInstructores = 0;
        totalConsultasProgramas = 0;
        totalGeneral = 0;
        System.out.println("Estadísticas reiniciadas");
    }
}