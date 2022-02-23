package com.example.proyectotallerdi.rest;

public class APIRestConfig {

    private APIRestConfig() {
    }

    public static AccesoDatosRest getService() {
        return RetrofitRestClient.getClient("https://jsonplaceholder.typicode.com/").create(AccesoDatosRest.class);
    }

}
