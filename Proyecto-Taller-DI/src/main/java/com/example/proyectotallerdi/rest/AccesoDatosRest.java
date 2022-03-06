package com.example.proyectotallerdi.rest;

import com.example.proyectotallerdi.entity.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AccesoDatosRest {

    //USUARIOS

    @GET("usuarios")
    Call<List<Usuario>> usuarioGetAll();

    @GET("usuarios/{id}")
    Call<Usuario> usuarioGetById(@Path("id") String id);

    @GET("usuarios/{id}/vehiculos")
    Call<List<Vehiculo>> usuarioGetVehiculos(@Path("id") String id);

    @POST("usuario")
    Call<Usuario> usuarioCreate(@Body Usuario user);

    @POST("login")
    Call<Login> loginCreate(@Body Login login);

    @POST("usuarios/{id}/citas")
    Call<Cita> usuarioCitaCreate(@Path("id") String id, @Body Cita cita);

    @PUT("usuarios/{id}")
    Call<Usuario> usarioUpdate(@Path("id") String id, @Body Usuario user);

    @DELETE("usuarios/{id}")
    Call<Usuario> usuarioDelete(@Path("id") String id);

    //SERVICIOS

    @GET("servicios")
    Call<List<Servicio>> serviciosGetAll();

    @GET("servicio/{id}")
    Call<Servicio> serviciosGetById(@Path("id") String id);

    @POST("servicio")
    Call<Servicio> serviciosCreate(@Body Servicio servicio);

    @PUT("servicio/{id}")
    Call<Servicio> serviciosUpdate(@Path("id") String id, @Body Servicio servicio);

    @DELETE("servicio/{id}")
    Call<Servicio> serviciosDelete(@Path("id") Long id);

    //CITAS

    @GET("citas")
    Call<List<Cita>> citasGetAll();

    @GET("cita/{id}")
    Call<Cita> citasGetById(@Path("id") String id);

    @POST("cita")
    Call<Cita> citaCreate(@Body Cita cita);

    @DELETE("cita/{id}")
    Call<Cita> citasDelete(@Path("id") String id);

    //Mecanico

    @GET("mecanicos")
    Call<List<Mecanico>> mecanicosGetAll();

    //Vehiculos
    @GET("vehiculos")
    Call<List<Vehiculo>> vehiculosGetAll();

}
