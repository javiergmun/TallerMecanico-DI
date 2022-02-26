package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Cita;
import com.example.proyectotallerdi.entity.Servicio;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.kordamp.ikonli.javafx.FontIcon;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ServicioController {
    private AccesoDatosRest restService = APIRestConfig.getService();
    @FXML
    private AnchorPane servicios;

    @FXML
    private ListView<Servicio> listaServicios;

    @FXML
    private FontIcon volver;
    @FXML
    private Text nombre;
    @FXML
    private Text descripcion;
    @FXML
    private Text precio;

    @FXML
    public void initialize() {

        ObservableList<Servicio> nombres = FXCollections.observableArrayList(
                cargarServicios()
        );
        listaServicios.setItems(nombres);
        listaServicios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                //No hay descripcion para servicios en la API
                nombre.setText(newValue.getTipo());
                precio.setText(String.valueOf(newValue.getPrecio()));
            }
        });

    }

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

    @FXML
    public void quitarServicio() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Borrar Elemento");
        alert.setContentText("¿Estas seguro de que quieres borrar el elemento?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            listaServicios.getItems().remove(0);
        } else {

        }
    }

    @FXML
    public void volver() {
        servicios.setTranslateX(-2000);
    }



}
