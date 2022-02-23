package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Cita;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class CitasController {
    private AccesoDatosRest restService = APIRestConfig.getService();

    @FXML
    private AnchorPane citas;


    public void volver() {
        citas.setTranslateY(2000);
    }



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
}
