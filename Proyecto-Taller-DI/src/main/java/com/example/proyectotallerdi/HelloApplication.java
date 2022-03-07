package com.example.proyectotallerdi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Locale localizacion = new Locale("es", "ES");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.example.proyectotallerdi.internacionalizacion.strings", localizacion);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"),resourceBundle);
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Taller 2ºDAM");
        stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2vYpgWZJufsavoiunqOO3JyRv9Le8IDu1YjyDltzzv4mLAD-Xb_D0KWpuCUwtyYEqgnQ&usqp=CAU"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}