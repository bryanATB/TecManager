package com.demo.tecmanager.dto.dashboard;

import java.util.List;

public class DashboardResponse {

    private long totalTareas;
    private long tareasPendientes;
    private long tareasEnProceso;
    private long tareasFinalizadas;
    private long tareasEnEspera;
    private long tareasVencidas;

    private double porcentajeFinalizadasATiempo;
    private double tiempoPromedioResolucionHoras;

    private long tareasAltaPrioridad;
    private long tareasMediaPrioridad;
    private long tareasBajaPrioridad;

    private List<TecnicoMetricaResponse> tecnicosConMasTareas;
    private List<TecnicoMetricaResponse> tecnicosMasEficientes;

    public DashboardResponse() {}

    public long getTotalTareas() { return totalTareas; }
    public long getTareasPendientes() { return tareasPendientes; }
    public long getTareasEnProceso() { return tareasEnProceso; }
    public long getTareasFinalizadas() { return tareasFinalizadas; }
    public long getTareasEnEspera() { return tareasEnEspera; }
    public long getTareasVencidas() { return tareasVencidas; }
    public double getPorcentajeFinalizadasATiempo() { return porcentajeFinalizadasATiempo; }
    public double getTiempoPromedioResolucionHoras() { return tiempoPromedioResolucionHoras; }
    public long getTareasAltaPrioridad() { return tareasAltaPrioridad; }
    public long getTareasMediaPrioridad() { return tareasMediaPrioridad; }
    public long getTareasBajaPrioridad() { return tareasBajaPrioridad; }
    public List<TecnicoMetricaResponse> getTecnicosConMasTareas() { return tecnicosConMasTareas; }
    public List<TecnicoMetricaResponse> getTecnicosMasEficientes() { return tecnicosMasEficientes; }


    public void setTotalTareas(long totalTareas) { this.totalTareas = totalTareas; }
    public void setTareasPendientes(long tareasPendientes) { this.tareasPendientes = tareasPendientes; }
    public void setTareasEnProceso(long tareasEnProceso) { this.tareasEnProceso = tareasEnProceso; }
    public void setTareasFinalizadas(long tareasFinalizadas) { this.tareasFinalizadas = tareasFinalizadas; }
    public void setTareasEnEspera(long tareasEnEspera) { this.tareasEnEspera = tareasEnEspera; }
    public void setTareasVencidas(long tareasVencidas) { this.tareasVencidas = tareasVencidas; }
    public void setPorcentajeFinalizadasATiempo(double p) { this.porcentajeFinalizadasATiempo = p; }
    public void setTiempoPromedioResolucionHoras(double t) { this.tiempoPromedioResolucionHoras = t; }
    public void setTareasAltaPrioridad(long tareasAltaPrioridad) { this.tareasAltaPrioridad = tareasAltaPrioridad; }
    public void setTareasMediaPrioridad(long tareasMediaPrioridad) { this.tareasMediaPrioridad = tareasMediaPrioridad; }
    public void setTareasBajaPrioridad(long tareasBajaPrioridad) { this.tareasBajaPrioridad = tareasBajaPrioridad; }
    public void setTecnicosConMasTareas(List<TecnicoMetricaResponse> t) { this.tecnicosConMasTareas = t; }
    public void setTecnicosMasEficientes(List<TecnicoMetricaResponse> t) { this.tecnicosMasEficientes = t; }

}
