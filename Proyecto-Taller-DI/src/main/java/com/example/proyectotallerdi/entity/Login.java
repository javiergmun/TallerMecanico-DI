package com.example.proyectotallerdi.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private long id;
    private Boolean activo;
    private String token;



    public long getId() {return id;}
    public void setId(long id) {this.id = id;}


    public Boolean getActivo() {return activo;}
    public void setActivo(Boolean activo) {this.activo = activo;}


    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", activo=" + activo +
                ", token='" + token + '\'' +
                '}';
    }
}
