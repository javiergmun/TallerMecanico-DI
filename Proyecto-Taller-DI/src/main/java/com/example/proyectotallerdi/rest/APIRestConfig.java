package com.example.proyectotallerdi.rest;

public class APIRestConfig {

    private APIRestConfig() {
    }

    public static AccesoDatosRest getService() {
        return RetrofitRestClient.getClient("http://localhost:8080/").create(AccesoDatosRest.class);
    }

}
