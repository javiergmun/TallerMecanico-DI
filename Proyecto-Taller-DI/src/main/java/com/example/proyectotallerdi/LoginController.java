package com.example.proyectotallerdi;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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

    @FXML
    private Text rellenar;


    public void borrarCampos() {
        contraseña.setText("");
        usuario.setText("");
    }

    @FXML
    public void sinRellenar() {
        if (usuario.getText() == "" | contraseña.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Cuidado");
            alert.setContentText("No has rellenado todos los campos");
            alert.showAndWait();
            rellenar.setVisible(true);
        } else
            login.setTranslateY(2000);
    }
}
