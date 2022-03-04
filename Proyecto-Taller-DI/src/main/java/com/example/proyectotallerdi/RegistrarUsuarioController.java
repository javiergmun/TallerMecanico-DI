package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Cita;
import com.example.proyectotallerdi.entity.Usuario;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.kordamp.ikonli.javafx.FontIcon;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class RegistrarUsuarioController {
    private AccesoDatosRest restService = APIRestConfig.getService();
    @FXML
    private FontIcon volver;
    @FXML
    private AnchorPane vistaRegistroUsuario;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField telefonoField;
    @FXML
    private TextField direccionField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField contraseñaField;
    @FXML
    private TextField dniField;
    @FXML
    private Text rellenar;

    private Usuario insertarUsuario(){

        Usuario usuario = Usuario.builder()
                .dni(dniField.getText())
                .nombre(nombreField.getText())
                .correo(emailField.getText())
                .telefono(telefonoField.getText())
                //.direccion.setCalle(direccionField.getText())
                .password(contraseñaField.getText())
                .build();

        return usuario;
    }

    private Usuario postUsuario() {
        try {
            Response<Usuario> response = restService.usuarioCreate(insertarUsuario()).execute();
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
    public void volverVista() {
        vistaRegistroUsuario.setTranslateX(2000);
    }

    @FXML
    public void borrarCampos() {
        nombreField.setText("");
        emailField.setText("");
        direccionField.setText("");
        telefonoField.setText("");
        contraseñaField.setText("");
    }

    @FXML
    public void sinRellenar() {
        if (nombreField.getText() == "" | emailField.getText() == ""
                | direccionField.getText() == "" | telefonoField.getText() == "" | contraseñaField.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Cuidado");
            alert.setContentText("No has rellenado todos los campos");
            alert.showAndWait();
            rellenar.setVisible(true);
        } else
            postUsuario();
            vistaRegistroUsuario.setTranslateX(2000);
    }
}
