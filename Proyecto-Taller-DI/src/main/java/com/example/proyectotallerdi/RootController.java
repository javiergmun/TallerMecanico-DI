package com.example.proyectotallerdi;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.kordamp.ikonli.Ikonli;
import org.kordamp.ikonli.javafx.FontIcon;

public class RootController {
    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane vistaLogin;

    @FXML
    private AnchorPane vistaRegistro;

    @FXML
    private VBox vBox;
    @FXML
    private FontIcon menu;

    @FXML
    private AnchorPane login;

    private LoginController loginController = new LoginController();

    private Animation animacion;

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
    public void salir() {
        System.exit(0);
    }

}