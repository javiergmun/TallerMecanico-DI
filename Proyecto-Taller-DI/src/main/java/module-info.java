module com.example.proyectotallerdi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires com.google.gson;
    requires lombok;

    opens com.example.proyectotallerdi to javafx.fxml;
    opens com.example.proyectotallerdi.entity to javafx.fxml;
    opens com.example.proyectotallerdi.rest to javafx.fxml;
    exports com.example.proyectotallerdi;
    exports com.example.proyectotallerdi.entity;
    exports com.example.proyectotallerdi.rest;


}