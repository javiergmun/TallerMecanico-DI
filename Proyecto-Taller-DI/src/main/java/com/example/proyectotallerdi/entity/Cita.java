package com.example.proyectotallerdi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {

    private long id;
    private String fecha;
    private Usuario usuario;
    private Mecanico mecanico;
    private Servicio servicio;
    private Vehiculo vehiculo;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}

    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Mecanico getMecanico() {return mecanico;}
    public void setMecanico(Mecanico mecanico) {this.mecanico = mecanico;}

    public Servicio getServicio() {return servicio;}
    public void setServicio(Servicio servicio) {this.servicio = servicio;}

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return fecha.substring(0,10)+" "+usuario.getUsername() ;
    }
}
