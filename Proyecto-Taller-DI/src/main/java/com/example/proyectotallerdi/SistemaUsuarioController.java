package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Usuario;
import com.example.proyectotallerdi.entity.Vehiculo;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class SistemaUsuarioController {
    private AccesoDatosRest restService = APIRestConfig.getService();

    @FXML
    private AnchorPane sistemaUsuario;

    @FXML
    private PieChart grafico;

    @FXML
    private TableView usuarios;

    @FXML
    private TableColumn<?, ?> nombre;
    @FXML
    private TableColumn<?, ?> dni;
    @FXML
    private TableColumn<?, ?> telefono;

    @FXML
    public void initialize() {

        ObservableList<Usuario> tabla;

        usuarios.setEditable(true);

        nombre.setCellValueFactory(new PropertyValueFactory<>("Username"));
        dni.setCellValueFactory(new PropertyValueFactory<>("Dni"));
        telefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));

        tabla = FXCollections.observableArrayList(
                cargarUsuario()
        );
        usuarios.setItems(tabla);

        ObservableList<Vehiculo> vehiculos = cargarVehiculo();

        int contadorAudi = 0;
        for (Vehiculo e : vehiculos) {
            if (e.getMarca().equals("Audi")) {

                contadorAudi++;
            }
        }
        int contadorMercedes = 0;
        for (Vehiculo e : vehiculos) {
            if (e.getMarca().equals("Mercedes")) {

                contadorMercedes++;
            }
        }
        int contadorBMV = 0;
        for (Vehiculo e : vehiculos) {
            if (e.getMarca().equals("BMV")) {

                contadorBMV++;
            }
        }
        int contadorCitroen = 0;
        for (Vehiculo e : vehiculos) {
            if (e.getMarca().equals("Citroen")) {

                contadorCitroen++;
            }
        }

        ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("Audi", contadorAudi),
                new PieChart.Data("Mercedes", contadorMercedes),
                new PieChart.Data("BMV", contadorBMV),
                new PieChart.Data("Citroen", contadorCitroen)
        );
        grafico.setData(datosGraficoCircular);
        grafico.setClockwise(false);
        grafico.setTitle("Coches de clientes");

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


    //Vehiculos
    private ObservableList<Vehiculo> cargarVehiculo() {
        List<Vehiculo> noObservable = getVehiculo();
        if (noObservable != null) {
            return FXCollections.observableArrayList(noObservable);
        } else {
            return null;
        }
    }

    private List<Vehiculo> getVehiculo() {
        try {
            Response<List<Vehiculo>> response = restService.vehiculosGetAll().execute();
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
        sistemaUsuario.setTranslateX(-2000);
    }

}
