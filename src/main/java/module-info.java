module es.liernisarraoa.ejercicio4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.sql;
    requires jcommon;


    opens es.liernisarraoa.ejercicio4 to javafx.fxml;
    exports es.liernisarraoa.ejercicio4;
    exports es.liernisarraoa.ejercicio4.Controlador;
    opens es.liernisarraoa.ejercicio4.Controlador to javafx.fxml;
}