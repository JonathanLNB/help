module com.example.tarea1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tarea1 to javafx.fxml;
    exports com.example.tarea1;
    exports com.example.tarea1.dao;
    opens com.example.tarea1.dao to javafx.fxml;
}