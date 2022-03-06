package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Cita;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.kordamp.ikonli.Ikonli;
import org.kordamp.ikonli.javafx.FontIcon;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class RootController {
    private AccesoDatosRest restService = APIRestConfig.getService();
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane vistaLogin;

    @FXML
    private AnchorPane vistaRegistro;

    @FXML
    private AnchorPane vistaServicio;

    @FXML
    private AnchorPane vistaCitas;

    @FXML
    private AnchorPane vistaSistema;

    @FXML
    private VBox vBox;
    @FXML
    private FontIcon menu;

    @FXML
    private AnchorPane login;

    private Animation animacion;

    private ServicioController servicioController;

    @FXML
    private ListView<Cita> citasHoy;

    @FXML
    private TextField textHora;
    @FXML
    private TextField textUsuario;
    @FXML
    private TextField textServicio;
    @FXML
    private TextField textPrecio;
    @FXML
    private TextField textMarca;
    @FXML
    private TextField textModelo;
    @FXML
    private TextField textMecanico;

    @FXML
    public void initialize(){

        ObservableList<Cita> citas = FXCollections.observableArrayList(
                cargarCitas()
        );

        citasHoy.setItems(citas);
        citasHoy.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                textHora.setText(newValue.getFecha().substring(11,16));
                textUsuario.setText(newValue.getUsuario().getNombre());
                textServicio.setText(newValue.getServicio().getTipo());
                textPrecio.setText(String.valueOf(newValue.getServicio().getPrecio()));
                textMecanico.setText(newValue.getMecanico().getNombre());
                textMarca.setText("");
                textModelo.setText("");
            }

        });
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



    @FXML
    public void iniciarVbox() {

        if (menu.getTranslateX() == 0) {
            vBox.setTranslateX(0);
            menu.setTranslateX(120);
            menu.setIconLiteral("fas-arrow-circle-left");
            vBox.setEffect(new DropShadow());
        } else {
            vBox.setTranslateX(-150);
            menu.setTranslateX(0);
            menu.setIconLiteral("fas-bars");
        }
    }

    @FXML
    public void iniciarVistaRegistro() {

        vistaLogin.setTranslateY(1500);
        menu.setTranslateX(0);
        menu.setIconLiteral("fas-bars");
        vBox.setTranslateX(-150);
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {

            vistaRegistro.setTranslateX(vistaRegistro.getTranslateX() - 100);
            detectarColision();
        }));
        animacion.setCycleCount(Animation.INDEFINITE);
        animacion.play();
    }

    public void detectarColision() {
        if (vistaRegistro.getBoundsInParent().intersects(vBox.getBoundsInParent())) {
            vistaRegistro.setTranslateX(0);
            animacion.stop();
        }
    }

    @FXML
    public void iniciarVistaServicio() {
        menu.setTranslateX(0);
        menu.setIconLiteral("fas-bars");
        vBox.setTranslateX(-150);
        vistaServicio.setTranslateX(0);
        vistaServicio.setTranslateZ(20);
    }

    @FXML
    public void iniciarVistaCitas() {
        menu.setTranslateX(0);
        menu.setIconLiteral("fas-bars");
        vBox.setTranslateX(-150);
        vistaCitas.setTranslateY(0);
    }

    @FXML
    public void iniciarVistaSistema() {
        menu.setTranslateX(0);
        menu.setIconLiteral("fas-bars");
        vistaSistema.setTranslateX(0);

    }

    @FXML
    public void salir() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de que quieres salir?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            System.exit(0);
        } else {
        }

    }

    @FXML
    public void cambiarIdioma(){

        Locale localizacion = new Locale("en", "UK");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.example.proyectotallerdi.internacionalizacion.strings", localizacion);



    }

}