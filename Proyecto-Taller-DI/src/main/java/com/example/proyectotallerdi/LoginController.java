package com.example.proyectotallerdi;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
    @FXML
    private AnchorPane login;
    @FXML
    private Button insertar;
    @FXML
    private Button borrar;
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contraseña;


    public void iniciar() {
        login.setTranslateY(+2000);
    }

    public void borrarCampos() {
        contraseña.setText("");
        usuario.setText("");
    }
}
