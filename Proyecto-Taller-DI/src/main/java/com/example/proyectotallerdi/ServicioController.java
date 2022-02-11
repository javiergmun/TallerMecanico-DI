package com.example.proyectotallerdi;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.kordamp.ikonli.javafx.FontIcon;

public class ServicioController {

    @FXML
    private AnchorPane servicios;


    @FXML
    private ListView listaServicios;

    @FXML
    private FontIcon volver;


    @FXML
    public void volver(){
        servicios.setTranslateX(-2000);
    }

    @FXML
    public void cargarLista(){

        ObservableList<String> nombres= FXCollections.observableArrayList("Aceite","Pintura","Equilibrado de ruedas");
        listaServicios.setItems(nombres);

    }



}
