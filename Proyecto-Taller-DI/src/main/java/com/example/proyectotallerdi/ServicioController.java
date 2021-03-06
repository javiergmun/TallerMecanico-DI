package com.example.proyectotallerdi;

import com.example.proyectotallerdi.entity.Servicio;
import com.example.proyectotallerdi.rest.APIRestConfig;
import com.example.proyectotallerdi.rest.AccesoDatosRest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.kordamp.ikonli.javafx.FontIcon;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class ServicioController {
    private AccesoDatosRest restService = APIRestConfig.getService();
    @FXML
    private AnchorPane servicios;

    @FXML
    private AnchorPane insertarServicio;

    @FXML
    private ListView<Servicio> listaServicios;

    @FXML
    private FontIcon volver;
    @FXML
    private ImageView imagenServicio;
    @FXML
    private Text nombre;
    @FXML
    private Text descripcion;
    @FXML
    private Text precio;

    @FXML
    public void initialize() {

        ObservableList<Servicio> nombres = FXCollections.observableArrayList(
                cargarServicios()
        );
        listaServicios.setItems(nombres);
        listaServicios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                nombre.setText(newValue.getTipo().toUpperCase(Locale.ROOT));
                precio.setText(String.valueOf(newValue.getPrecio()));
                descripcion.setText(newValue.getDescripcion());
                Image img = new Image(newValue.getImagen());
                imagenServicio.setImage(img);
            }
        });

    }

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
    private Servicio deleteServicio(Long id) {
        try {
            Response<Servicio> response = restService.serviciosDelete(id).execute();
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
    public void quitarServicio() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Borrar Elemento");
        alert.setContentText("??Estas seguro de que quieres borrar el elemento?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            int indice= listaServicios.getSelectionModel().getSelectedIndex();
            listaServicios.getItems().remove(indice);
            deleteServicio(Long.valueOf(indice));
        } else {

        }
    }

    @FXML
    public void insertServ(){
        insertarServicio.setTranslateX(0);
    }
    @FXML
    public void back() {
        insertarServicio.setTranslateX(+1000);
    }
    @FXML
    public void volver() {
        servicios.setTranslateX(-2000);
    }


    @FXML
    private TextField insertNombre;
    @FXML
    private TextArea insertDescripcion;
    @FXML
    private TextField insertPrecio;
    @FXML
    private TextField insertTiempo;
    @FXML
    private ImageView insertFoto;



    @FXML
    public void cargarFoto(){
        FileChooser file = new FileChooser();

        File foto =file.showOpenDialog(null);

        Image img = new Image(foto.toURI().toString());
        insertFoto.setImage(img);

    }
    public Servicio insertarServicio(){
        Servicio ser = Servicio.builder()
                .tipo(insertNombre.getText())
                .descripcion(insertDescripcion.getText())
                .precio(Double.valueOf(insertPrecio.getText()))
                .tiempo(Double.valueOf(insertTiempo.getText()))
                .imagen(insertFoto.getImage().getUrl())
                .build();
        return ser;
    }

    private Servicio postServicio() {
        try {
            Response<Servicio> response = restService.serviciosCreate(insertarServicio()).execute();
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
    public void servicioInsertado(){
        if (imagenServicio==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Cuidado");
            alert.setContentText("No has metido la foto");
            alert.showAndWait();
        }else
            postServicio();
    }




}
