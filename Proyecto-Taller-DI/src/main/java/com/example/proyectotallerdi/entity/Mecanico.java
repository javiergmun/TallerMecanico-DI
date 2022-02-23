package com.example.proyectotallerdi.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    private long id;
    private String nombre;
    private Double salario;


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}


    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Double getSalario() {return salario;}
    public void setSalario(Double salario) {this.salario = salario;}


    @Override
    public String toString() {
        return "Mecanico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                '}';
    }
}
