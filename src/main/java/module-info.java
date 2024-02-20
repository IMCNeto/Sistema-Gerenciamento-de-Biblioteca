module org.example.ssgbiblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uefs.sigbiblioteca to javafx.fxml;
    exports com.uefs.sigbiblioteca;
    exports com.uefs.sigbiblioteca.controller;
    opens com.uefs.sigbiblioteca.controller to javafx.fxml;
    opens com.uefs.sigbiblioteca.model;
}