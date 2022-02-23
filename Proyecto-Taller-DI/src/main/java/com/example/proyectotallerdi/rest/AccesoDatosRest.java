package com.example.proyectotallerdi.rest;


import com.example.proyectotallerdi.entity.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface AccesoDatosRest {

    @GET("users")
    Call<List<Usuario>> personasGetAll();

    @GET("users/{id}")
    Call<Usuario> personaGetById(@Path("id") String id);

}

