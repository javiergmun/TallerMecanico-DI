package com.example.proyectotallerdi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.Optional;

public class ServicioController {

    @FXML
    private AnchorPane servicios;

    @FXML
    private ListView listaServicios;

    @FXML
    private FontIcon volver;

    @FXML
    public void volver() {
        servicios.setTranslateX(-2000);
    }

    @FXML
    public void cargarLista() {

        ObservableList<String> nombres = FXCollections.observableArrayList("Aceite", "Pintura", "Equilibrado de ruedas");
        listaServicios.setItems(nombres);

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


}
