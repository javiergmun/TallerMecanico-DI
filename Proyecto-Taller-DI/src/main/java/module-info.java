module com.example.proyectotallerdi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;


    opens com.example.proyectotallerdi to javafx.fxml;
    exports com.example.proyectotallerdi;
}