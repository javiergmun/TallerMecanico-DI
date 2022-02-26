package com.example.proyectotallerdi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {

    private long id;
    private LocalDateTime fecha;
    private Usuario usuario;
    private Mecanico mecanico;
    private Servicio servicio;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public LocalDateTime getFecha() {return fecha;}
    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}

    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Mecanico getMecanico() {return mecanico;}
    public void setMecanico(Mecanico mecanico) {this.mecanico = mecanico;}

    public Servicio getServicio() {return servicio;}
    public void setServicio(Servicio servicio) {this.servicio = servicio;}

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", usuario=" + usuario +
                ", mecanico=" + mecanico +
                ", servicio=" + servicio +
                '}';
    }
}
