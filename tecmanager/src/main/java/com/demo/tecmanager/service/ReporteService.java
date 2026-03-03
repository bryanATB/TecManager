package com.demo.tecmanager.service;

import com.demo.tecmanager.document.Reporte;
import com.demo.tecmanager.exception.ResourceNotFoundException;
import com.demo.tecmanager.repository.ReporteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.data.repository.support.Repositories;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;

    @Autowired
    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    public List<Reporte> obtenerPorTarea(String tareaId) {
        List<Reporte> reportes = reporteRepository.findByTareaId(tareaId);
        if (reportes.isEmpty()) {
            throw new ResourceNotFoundException("no hay reportes para la tarea id: " + tareaId);

        }
        return reportes;
    }

    public List<Reporte> obtenerPorTecnico(String tecnicoId) {
        List<Reporte> reportes = reporteRepository.findByTecnicoId(tecnicoId);
        if (reportes.isEmpty()) {
            throw new ResourceNotFoundException("no hay reportes para el tecnico con id " + tecnicoId);
        }
        return reportes;
    }

    public Reporte obtenerPorId(String id) {
        return reporteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado con id: " + id));
    }

    public boolean tienereporte(String tareaId) {
        return reporteRepository.existsByTareaId(tareaId);
    }

    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }
}
