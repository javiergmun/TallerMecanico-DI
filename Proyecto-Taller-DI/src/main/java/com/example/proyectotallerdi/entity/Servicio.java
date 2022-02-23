package com.example.proyectotallerdi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Servicio {

    private long id;
    private Double precio;
    private String tipo;
    private Double tiempo;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private boolean activo = true;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Double getTiempo() {
        return tiempo;
    }
    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }


    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }


    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", tiempo=" + tiempo +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                '}';
    }
}
