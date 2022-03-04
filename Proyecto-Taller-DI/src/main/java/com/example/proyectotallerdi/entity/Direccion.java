package com.example.proyectotallerdi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Direccion {

    private long id;
    private String calle;
    private String numero;
    private String codigo;
    private String localidad;


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getCalle() {return calle;}
    public void setCalle(String calle) {this.calle = calle;}

    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}

    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getLocalidad() {return localidad;}
    public void setLocalidad(String localidad) {this.localidad = localidad;}

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", codigo='" + codigo + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
