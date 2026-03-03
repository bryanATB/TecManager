package com.demo.tecmanager.dto.dashboard;

public class TecnicoMetricaResponse {

    private String tecnicoId;
    private String tecnicoNombre;
    private long totalTareasActivas;
    private long totalTareasFinalizadas;
    private double tiempoPromedioHoras;

    public TecnicoMetricaResponse() {}

    public TecnicoMetricaResponse(String tecnicoId, String tecnicoNombre, long totalTareasActivas, long totalTareasFinalizadas, double tiempoPromedioHoras) {
        this.tecnicoId = tecnicoId;
        this.tecnicoNombre = tecnicoNombre;
        this.totalTareasActivas = totalTareasActivas;
        this.totalTareasFinalizadas = totalTareasFinalizadas;
        this.tiempoPromedioHoras = tiempoPromedioHoras;
    }

    public String getTecnicoId() { return tecnicoId; }
    public String getTecnicoNombre() { return tecnicoNombre; }
    public long getTotalTareasActivas() { return totalTareasActivas; }
    public long getTotalTareasFinalizadas() { return totalTareasFinalizadas; }
    public double getTiempoPromedioHoras() { return tiempoPromedioHoras; }


    public void setTecnicoId(String tecnicoId) { this.tecnicoId = tecnicoId; }
    public void setTecnicoNombre(String tecnicoNombre) { this.tecnicoNombre = tecnicoNombre; }
    public void setTotalTareasActivas(long t) { this.totalTareasActivas = t; }
    public void setTotalTareasFinalizadas(long t) { this.totalTareasFinalizadas = t; }
    public void setTiempoPromedioHoras(double t) { this.tiempoPromedioHoras = t; }

}
