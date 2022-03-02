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
    private String nombre;
    private Boolean administrador;
    private String telefono;
    private Direccion direccion;
    private String correo;
    private String password;
    private Set<Vehiculo> vehiculos;
    private Login login;


    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Boolean getAdministrador() {return administrador;}
    public void setAdministrador(Boolean administrador) {this.administrador = administrador;}

    public String getTelefono() {return telefono;}
    public void setTelefono(String phone) {this.telefono = phone;}

    public Direccion getDireccion() {return direccion;}
    public void setDireccion(Direccion address) {this.direccion = address;}

    public String getCorreo() {return correo;}
    public void setCorreo(String email) {this.correo = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Set<Vehiculo> getVehiculos() {return vehiculos;}
    public void setVehiculos(Set<Vehiculo> vehiculos) {this.vehiculos = vehiculos;}

    public Login getLogin() {return login;}
    public void setLogin(Login login) {this.login = login;}

    @Override
    public String toString() {
        return nombre;
    }
}
