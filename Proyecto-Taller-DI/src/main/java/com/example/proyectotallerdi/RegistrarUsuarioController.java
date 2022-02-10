package com.example.proyectotallerdi;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.kordamp.ikonli.javafx.FontIcon;

public class RegistrarUsuarioController {

    @FXML
    private FontIcon volver;
    @FXML
    private AnchorPane vistaRegistroUsuario;
    @FXML
    private TextField nombre;
    @FXML
    private TextField telefono;
    @FXML
    private TextField direccion;
    @FXML
    private TextField email;
    @FXML
    private PasswordField contraseña;

    @FXML
    public void volverVista() {
        vistaRegistroUsuario.setTranslateX(2000);
    }

    @FXML
    public void borrarCampos() {
        nombre.setText("");
        email.setText("");
        direccion.setText("");
        telefono.setText("");
        contraseña.setText("");
    }
}
