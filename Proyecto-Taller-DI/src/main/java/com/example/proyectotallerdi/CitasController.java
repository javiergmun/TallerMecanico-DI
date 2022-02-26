package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Cita;
import com.example.proyectotallerdi.entity.Servicio;
import com.example.proyectotallerdi.entity.Usuario;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class CitasController {
    private AccesoDatosRest restService = APIRestConfig.getService();

    @FXML
    private AnchorPane citas;

    @FXML
    private ComboBox<Usuario> usuarios;
    @FXML
    private ComboBox<Servicio> servicios;


    @FXML
    public void initialize(){

        ObservableList<Usuario> comboUsuarios = FXCollections.observableArrayList(
                cargarUsuario()
        );
        usuarios.setItems(comboUsuarios);

        ObservableList<Servicio> comboServicios = FXCollections.observableArrayList(
                cargarServicios()
        );
        servicios.setItems(comboServicios);

    }

    //Usuarios
    private ObservableList<Usuario> cargarUsuario() {
        List<Usuario> noObservable = getUsuarios();
        if (noObservable != null) {
            return FXCollections.observableArrayList(noObservable);
        } else {
            return null;
        }
    }

    private List<Usuario> getUsuarios() {
        try {

            Response<List<Usuario>> response = restService.usuarioGetAll().execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Servicios
    private ObservableList<Servicio> cargarServicios() {
        List<Servicio> noObservable = getServicios();
        if (noObservable != null) {
            return FXCollections.observableArrayList(noObservable);
        } else {
            return null;
        }
    }

    private List<Servicio> getServicios() {
        try {
            Response<List<Servicio>> response = restService.serviciosGetAll().execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Citas
    private ObservableList<Cita> cargarCitas() {
        List<Cita> noObservable = getCitas();
        if (noObservable != null) {
            return FXCollections.observableArrayList(noObservable);
        } else {
            return null;
        }
    }

    private List<Cita> getCitas() {
        try {

            Response<List<Cita>> response = restService.citasGetAll().execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void volver() {
        citas.setTranslateY(2000);
    }
}
