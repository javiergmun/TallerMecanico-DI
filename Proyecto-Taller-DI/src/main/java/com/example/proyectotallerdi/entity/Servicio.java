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




    @Override
    public String toString() {
        return tipo;
    }
}
