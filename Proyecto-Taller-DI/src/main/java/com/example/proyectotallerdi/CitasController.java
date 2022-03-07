package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.*;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
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
    private ComboBox<Mecanico> mecanico;
    @FXML
    private ComboBox<Vehiculo> vehiculo;

    @FXML
    private DatePicker pickerDay;

    @FXML
    private ListView<String> horas;


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
        ObservableList<Mecanico> comboMecanico = FXCollections.observableArrayList(
                cargarMecanicos()
        );
        mecanico.setItems(comboMecanico);
        ObservableList<Vehiculo> comboVehiculos= FXCollections.observableArrayList(
                cargarVehiculo()
        );
        vehiculo.setItems(comboVehiculos);

        pickerDay.setShowWeekNumbers(true);
        Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                this.setDisable(false);
                this.setBackground(null);
                this.setTextFill(Color.BLACK);
                // fines de semana en color rojo y deshabilitados
                DayOfWeek dayweek = item.getDayOfWeek();
                if (dayweek == DayOfWeek.SATURDAY || dayweek == DayOfWeek.SUNDAY) {
                    this.setDisabled(true);
                    this.setTextFill(Color.RED);
                }
            }
        };
        pickerDay.setDayCellFactory(dayCellFactory);

        ObservableList<String> listaHoras = FXCollections.observableArrayList(
                "9:30","10:00","11:30","12:00","13:00","14:00","16:00","16:30","17:00"
        );

        pickerDay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                horas.setItems(listaHoras);
            }
        });

    }

    public Cita citaBuilder(){


        Cita cita = Cita.builder()
                .usuario(usuarios.getValue())
                .mecanico(mecanico.getValue())
                .servicio(servicios.getValue())
                .vehiculo(vehiculo.getValue())
                .fecha(pickerDay.getValue().toString()+"T"+ horas.getSelectionModel().getSelectedItem())
                .build();

       // System.out.println(pickerDay.getValue().toString()+"T"+horas.getSelectionModel().getSelectedItem().toString());
        return cita;
    }
    @FXML
    public void insertarCita(){
        if (usuarios.getValue()==null || mecanico.getValue()==null || servicios.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Cuidado");
            alert.setContentText("No has rellenado todos los campos");
            alert.showAndWait();
        } else
            postCita();

    }

    //Cita Post
    private Cita postCita() {
        try {
            Response<Cita> response = restService.citaCreate(citaBuilder()).execute();
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
    //Mecanico
    private ObservableList<Mecanico> cargarMecanicos() {
        List<Mecanico> noObservable = getMecanicos();
        if (noObservable != null) {
            return FXCollections.observableArrayList(noObservable);
        } else {
            return null;
        }
    }

    private List<Mecanico> getMecanicos() {
        try {

            Response<List<Mecanico>> response = restService.mecanicosGetAll().execute();
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
        citas.setTranslateY(2000);
    }
}
