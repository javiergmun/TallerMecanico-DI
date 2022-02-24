package com.example.proyectotallerdi.rest;

import com.example.proyectotallerdi.entity.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AccesoDatosRest {

    //USUARIOS

    @GET("usuarios")
    Call<List<Usuario>> personasGetAll();

    @GET("usuarios/{id}")
    Call<Usuario> personaGetById(@Path("id") String id);

    @GET("usuarios/{id}/vehiculos")
    Call<List<Vehiculo>> usuarioGetVehiculos(@Path("id") String id);

    @POST("usuarios")
    Call<Usuario> usersCreate(@Body Usuario user);

    @POST("login")
    Call<Login> usersCreate(@Body Login login);

    @POST("usuarios/{id}/citas")
    Call<Cita> usersCreate(@Path("id") String id, @Body Cita cita);

    @PUT("usuarios/{id}")
    Call<Usuario> userUpdate(@Path("id") String id, @Body Usuario user);

    @DELETE("usuarios/{id}")
    Call<Usuario> userDelete(@Path("id") String id);

    //SERVICIOS

    @GET("servicios")
    Call<List<Servicio>> serviciosGetAll();

    @GET("servicios/{id}")
    Call<Servicio> serviciosGetById(@Path("id") String id);

    @POST("servicios")
    Call<Servicio> serviciosCreate(@Body Servicio servicio);

    @PUT("servicios/{id}")
    Call<Servicio> serviciosUpdate(@Path("id") String id, @Body Servicio servicio);

    @DELETE("servicios/{id}")
    Call<Servicio> serviciosDelete(@Path("id") String id);

    //CITAS

    @GET("citas")
    Call<List<Cita>> citasGetAll();

    @GET("citas/{id}")
    Call<Cita> citasGetById(@Path("id") String id);

    @DELETE("citas/{id}")
    Call<Cita> citasDelete(@Path("id") String id);

}