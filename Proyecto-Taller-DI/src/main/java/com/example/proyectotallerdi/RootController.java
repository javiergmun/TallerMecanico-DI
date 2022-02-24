package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Cita;
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

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class RootController {
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
    public void initialize(){
        ObservableList<Cita> citas = FXCollections.observableArrayList(
                //new Cita(1,3.4,"","","","")
        );

        citasHoy.setItems(citas);
        citasHoy.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){

            }

        });
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
        vistaLogin.setTranslateY(1500);
        vistaServicio.setTranslateX(0);
        vistaServicio.setTranslateZ(20);

    }

    @FXML
    public void iniciarVistaCitas() {
        menu.setTranslateX(0);
        menu.setIconLiteral("fas-bars");
        vBox.setTranslateX(-150);
        vistaLogin.setTranslateY(1500);
        vistaCitas.setTranslateY(0);
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