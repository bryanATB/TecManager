package com.demo.tecmanager.dto.reporte;

import com.demo.tecmanager.enums.EstadoTarea;
import java.time.LocalDateTime;

public class ReporteResponse {

    private String id;
    private String tareaId;
    private String tareaTitulo;
    private String tecnicoId;
    private String tecnicoNombre;
    private String comentario;
    private EstadoTarea estadoFinal;
    private LocalDateTime fecha;

    public ReporteResponse() {}

    public String getId() { return id; }
    public String getTareaId() { return tareaId; }
    public String getTareaTitulo() { return tareaTitulo; }
    public String getTecnicoId() { return tecnicoId; }
    public String getTecnicoNombre() { return tecnicoNombre; }
    public String getComentario() { return comentario; }
    public EstadoTarea getEstadoFinal() { return estadoFinal; }
    public LocalDateTime getFecha() { return fecha; }


    public void setId(String id) { this.id = id; }
    public void setTareaId(String tareaId) { this.tareaId = tareaId; }
    public void setTareaTitulo(String tareaTitulo) { this.tareaTitulo = tareaTitulo; }
    public void setTecnicoId(String tecnicoId) { this.tecnicoId = tecnicoId; }
    public void setTecnicoNombre(String tecnicoNombre) { this.tecnicoNombre = tecnicoNombre; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setEstadoFinal(EstadoTarea estadoFinal) { this.estadoFinal = estadoFinal; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

}
