package com.example.proyectotallerdi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    private long id;
    private String dni;
    private String username;
    //private Boolean administrador;
    private String telefono;
    //private Direccion direccion;
    private String correo;
    private String password;
    private Set<Vehiculo> vehiculos;
   // private Login login;
    private String direccion;



    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public String getDireccion() {
        return direccion;}
    public void setDireccion(String direccion) {
        this.direccion = direccion;}

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}


    public String getTelefono() {return telefono;}
    public void setTelefono(String phone) {this.telefono = phone;}



    public String getCorreo() {return correo;}
    public void setCorreo(String email) {this.correo = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}


    @Override
    public String toString() {
        return username;
    }
}
